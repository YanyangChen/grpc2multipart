package org.apache.camel.example.springboot.grpc.converter;


import com.google.protobuf.compiler.PluginProtos;
import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;
import org.apache.camel.component.file.GenericFile;

import java.io.*;

@Converter(generateLoader = true)
public class File2BufferedConverter implements TypeConverters {

    @Converter
    public BufferedReader genericFileToInputStream(GenericFile<File> file) throws IOException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(file.getFile())));
    }

}