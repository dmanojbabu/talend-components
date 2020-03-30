package com.virtusa.talend.components.processor;

import static com.tableau.hyperapi.Nullability.NOT_NULLABLE;
import static com.tableau.hyperapi.Nullability.NULLABLE;
import static com.tableau.hyperapi.SqlType.*;
import static org.talend.sdk.component.api.component.Icon.IconType.CUSTOM;

import java.io.Serializable;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.tableau.hyperapi.HyperProcess;
import com.tableau.hyperapi.Inserter;
import com.tableau.hyperapi.Connection;
import com.tableau.hyperapi.Catalog;
import com.tableau.hyperapi.TableDefinition;
import com.tableau.hyperapi.Telemetry;
import com.tableau.hyperapi.CreateMode;
import com.tableau.hyperapi.TableName;
import com.tableau.hyperapi.SchemaName;
import com.tableau.hyperapi.Nullability;

import org.talend.sdk.component.api.component.Icon;
import org.talend.sdk.component.api.component.Version;
import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.meta.Documentation;
import org.talend.sdk.component.api.processor.AfterGroup;
import org.talend.sdk.component.api.processor.BeforeGroup;
import org.talend.sdk.component.api.processor.ElementListener;
import org.talend.sdk.component.api.processor.Input;
import org.talend.sdk.component.api.processor.Output;
import org.talend.sdk.component.api.processor.OutputEmitter;
import org.talend.sdk.component.api.processor.Processor;
import org.talend.sdk.component.api.record.Record;
import org.talend.sdk.component.api.record.Schema;

import com.virtusa.talend.components.service.VirtusaTalendComponentService;

@Version(1) // default version is 1, if some configuration changes happen between 2 versions you can add a migrationHandler
@Icon(value = CUSTOM, custom = "TableauHyperOutput") // icon is located at src/main/resources/icons/TableauHyperOutput.svg
@Processor(name = "HyperOutput")
@Documentation("TODO fill the documentation for this processor")
public class HyperOutputProcessor implements Serializable {
    private final HyperOutputProcessorConfiguration configuration;
    private final VirtusaTalendComponentService service;
    private HyperProcess process;
    private Inserter inserter;
    private Connection connection;
    private boolean isFirstRecord;
    private TableDefinition extractTable;

    public HyperOutputProcessor(@Option("configuration") final HyperOutputProcessorConfiguration configuration,
                                final VirtusaTalendComponentService service) {
        //System.out.println("Constructor");
        this.configuration = configuration;
        this.service = service;
    }

    @PostConstruct
    public void init() {
        // this method will be executed once for the whole component execution,
        // this is where you can establish a connection for instance
        // Note: if you don't need it you can delete it

        System.out.println("[Hyper Output Path:" + this.configuration.getOutputPath() + "]");
        System.out.println("[Schema Name:" + this.configuration.getSchemaName() + "]");
        System.out.println("[Table Name:" + this.configuration.getTableName() + "]");
        System.out.println("[Hyper Binary Path:" + this.configuration.getHyperBinPath() + "]");
        //System.out.println("[Hyper File Mode:" + this.configuration.getHyperFileMode() + "]");

        this.process = new HyperProcess(Paths.get(this.configuration.getHyperBinPath()),
                Telemetry.DO_NOT_SEND_USAGE_DATA_TO_TABLEAU);
        this.connection = new Connection(this.process.getEndpoint(),
                this.configuration.getOutputPath(),
                //CreateMode.valueOf(this.configuration.getHyperFileMode().toString())
                CreateMode.CREATE_AND_REPLACE);
        isFirstRecord = true;

    }


    @BeforeGroup
    public void beforeGroup() {
        // if the environment supports chunking this method is called at the beginning if a chunk
        // it can be used to start a local transaction specific to the backend you use
        // Note: if you don't need it you can delete it
    }

    @ElementListener
    public void onNext(
            @Input final Record defaultInput,
            @Output final OutputEmitter<Record> defaultOutput) {
        // this is the method allowing you to handle the input(s) and emit the output(s)
        // after some custom logic you put here, to send a value to next element you can use an
        // output parameter and call emit(value).
        System.out.println("["+configuration.getOutputPath().toUpperCase()+"] "+defaultInput);
        if(isFirstRecord){
            List<TableDefinition.Column> columns = getTableDefinition(defaultInput);
            this.extractTable = new TableDefinition(new TableName(this.configuration.getSchemaName(), this.configuration.getTableName()), columns);
            Catalog catalog = this.connection.getCatalog();
            catalog.createSchema(new SchemaName(this.configuration.getSchemaName()));
            catalog.createTable(this.extractTable);
        }
        isFirstRecord = false;
        Inserter inserter = new Inserter(connection, this.extractTable);
        for(Schema.Entry entry: defaultInput.getSchema().getEntries()){
            switch (entry.getType()){
                case INT:
                    inserter.add(defaultInput.getInt(entry.getName()));
                    break;
                case STRING:
                    inserter.add(defaultInput.getString(entry.getName()));
                    break;
                case LONG:
                    inserter.add(defaultInput.getLong(entry.getName()));
                    break;
                case FLOAT:
                    inserter.add(defaultInput.getFloat(entry.getName()));
                    break;
                case DOUBLE:
                    inserter.add(defaultInput.getDouble(entry.getName()));
                    break;
                case DATETIME:
                    inserter.add(defaultInput.getDateTime(entry.getName()));
                    break;
                case BOOLEAN:
                    inserter.add(defaultInput.getBoolean(entry.getName()));
                    break;
                default: //default case has been used to extract other formats if any which is missed to convert to String value
                    inserter.add(defaultInput.getString(entry.getName()));
            }
        }
        inserter.endRow();
        inserter.execute();
    }

    private List<TableDefinition.Column> getTableDefinition(Record defaultInput) {
        List<TableDefinition.Column> columns = new ArrayList<>();
        for(Schema.Entry entry: defaultInput.getSchema().getEntries()){
            Nullability nullability = entry.isNullable()? NULLABLE : NOT_NULLABLE;
            switch (entry.getType()){ //TODO: Handle other data types
                case INT:
                    columns.add(new TableDefinition.Column(entry.getName(),integer() , nullability));
                    break;
                case STRING:
                    columns.add(new TableDefinition.Column(entry.getName(), text(), nullability));
                    break;
                case LONG:
                    columns.add(new TableDefinition.Column(entry.getName(), bigInt() , nullability));
                    break;
                case FLOAT:
                    columns.add(new TableDefinition.Column(entry.getName(),doublePrecision(), nullability));
                    break;
                case DOUBLE:
                    columns.add(new TableDefinition.Column(entry.getName(), doublePrecision() , nullability));
                    break;
                case DATETIME:
                    columns.add(new TableDefinition.Column(entry.getName(), timestamp() , nullability));
                    break;
                case BOOLEAN:
                    columns.add(new TableDefinition.Column(entry.getName(), bool(), nullability));
                    break;
                default:
                    columns.add(new TableDefinition.Column(entry.getName(), text(), nullability));
            }
        }
        return columns;
    }

    @AfterGroup
    public void afterGroup() {
        // symmetric method of the beforeGroup() executed after the chunk processing
        // Note: if you don't need it you can delete it
    }

    @PreDestroy
    public void release() {
        // this is the symmetric method of the init() one,
        // release potential connections you created or data you cached
        // Note: if you don't need it you can delete it
        // The table names in the "Extract" schema
        List<TableName> tablesInDatabase = this.connection.getCatalog().getTableNames(new SchemaName(this.configuration.getSchemaName()));
        System.out.println("Generated Hyper file available in " + this.configuration.getOutputPath().toString() + " are: " + tablesInDatabase);

        // Number of rows in the "Extract"."Extract" table
        // executeScalarQuery is for executing a query that returns exactly one row with one column
        long rowCount = connection.<Long>executeScalarQuery(
                "SELECT COUNT(*) FROM " + this.extractTable.getTableName()
        ).get();
        System.out.println("The number of rows in table " + this.extractTable.getTableName() + " is " + rowCount + "\n");
        this.connection.close();
        System.out.println("The connection to the Hyper file has been closed");
        this.process.shutdown();
        System.out.println("The Hyper process has been shut down");
    }
}