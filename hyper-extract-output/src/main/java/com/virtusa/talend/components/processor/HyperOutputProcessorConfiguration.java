package com.virtusa.talend.components.processor;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.talend.sdk.component.api.component.Components;
import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.action.Proposable;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.configuration.ui.widget.Structure;
import org.talend.sdk.component.api.meta.Documentation;
import org.talend.sdk.component.api.service.completion.DynamicValues;
import org.talend.sdk.component.api.service.completion.Values;

import static java.util.Arrays.asList;

@GridLayout({
    // the generated layout put one configuration entry per line,
    // customize it as much as needed
    @GridLayout.Row( "outputPath" ),
        @GridLayout.Row( "schemaName" ),
        @GridLayout.Row( "tableName"),
        @GridLayout.Row("hyperBinPath"),
//        @GridLayout.Row("hyperFileMode")
})
@Documentation("TODO fill the documentation for this configuration")

public class HyperOutputProcessorConfiguration implements Serializable {
    @Option()
    @Documentation("TODO fill the documentation for this parameter")
    private String outputPath;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String schemaName;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String tableName;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String hyperBinPath;

 /*   @Option
    @Proposable("valuesProvider")
    @Documentation("TODO fill the documentation for this parameter")
    private String hyperFileMode;*/


    public String getOutputPath() {
        return outputPath;
    }

    public HyperOutputProcessorConfiguration setOutputPath(String outputPath) {
        this.outputPath = outputPath;
        return this;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public String getHyperBinPath() {
        return hyperBinPath;
    }

   /* public String getHyperFileMode() {
        return hyperFileMode;
    }*/

    public HyperOutputProcessorConfiguration setSchemaName(String schemaName) {
        this.schemaName = schemaName;
        return this;
    }

    public HyperOutputProcessorConfiguration setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public HyperOutputProcessorConfiguration setHyperBinPath(String hyperBinPath) {
        this.hyperBinPath = hyperBinPath;
        return this;
    }
    /*public HyperOutputProcessorConfiguration setHyperFileMode(String hyperFileMode) {
        this.hyperFileMode = hyperFileMode;
        return this;
    }*/
}