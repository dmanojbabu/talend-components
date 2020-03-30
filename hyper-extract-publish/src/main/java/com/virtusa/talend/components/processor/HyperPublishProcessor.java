package com.virtusa.talend.components.processor;

import static org.talend.sdk.component.api.component.Icon.IconType.CUSTOM;

import java.io.File;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.virtusa.talend.components.binding.DataSourceType;
import com.virtusa.talend.components.service.RestApiConnection;
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

import com.virtusa.talend.components.service.VirtusaTalendComponentServiceTmp;

@Version(1) // default version is 1, if some configuration changes happen between 2 versions you can add a migrationHandler
@Icon(value = CUSTOM, custom = "HyperPublish") // icon is located at src/main/resources/icons/HyperPublish.svg
@Processor(name = "HyperPublish")
@Documentation("TODO fill the documentation for this processor")
public class HyperPublishProcessor implements Serializable {
    private final HyperPublishProcessorConfiguration configuration;
    private final VirtusaTalendComponentServiceTmp service;
    private boolean isFirst;

    public HyperPublishProcessor(@Option("configuration") final HyperPublishProcessorConfiguration configuration,
                          final VirtusaTalendComponentServiceTmp service) {
        this.configuration = configuration;
        this.service = service;
    }

    @PostConstruct
    public void init() {
        // this method will be executed once for the whole component execution,
        // this is where you can establish a connection for instance
        // Note: if you don't need it you can delete it
        //this.service.publishHyperExtract(this.configuration);
        this.isFirst = true;

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


            try{
                RestApiConnection api = new RestApiConnection(configuration.getHostName());
                api.invokeSignIn(configuration.getUsername(), configuration.getPassword(), configuration.getContentUrl());
                String hyperFilePath = configuration.getDataSourcePath();
                DataSourceType dd = api.invokePublishDataSourceChunked(configuration.getProjectId(), configuration.getDatasourceName(), configuration.getDatasourceType(),
                        new File(hyperFilePath), configuration.getOverwrite(), configuration.getAppend());
                System.out.println("Published data source name:"+dd.getName());
                System.out.println("The Hyper file successfully published");
            }catch (Exception ex){
                System.err.println("The Hyper file publish failed:"+ex);
            }


    }
}