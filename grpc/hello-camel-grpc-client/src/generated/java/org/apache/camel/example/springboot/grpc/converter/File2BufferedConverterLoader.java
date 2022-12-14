/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.example.springboot.grpc.converter;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.DeferredContextBinding;
import org.apache.camel.Exchange;
import org.apache.camel.TypeConversionException;
import org.apache.camel.TypeConverterLoaderException;
import org.apache.camel.spi.TypeConverterLoader;
import org.apache.camel.spi.TypeConverterRegistry;
import org.apache.camel.support.SimpleTypeConverter;
import org.apache.camel.support.TypeConverterSupport;
import org.apache.camel.util.DoubleMap;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@SuppressWarnings("unchecked")
@DeferredContextBinding
public final class File2BufferedConverterLoader implements TypeConverterLoader, CamelContextAware {

    private CamelContext camelContext;

    public File2BufferedConverterLoader() {
    }

    @Override
    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    @Override
    public CamelContext getCamelContext() {
        return camelContext;
    }

    @Override
    public void load(TypeConverterRegistry registry) throws TypeConverterLoaderException {
        registerConverters(registry);
    }

    private void registerConverters(TypeConverterRegistry registry) {
        addTypeConverter(registry, java.io.BufferedReader.class, org.apache.camel.component.file.GenericFile.class, false,
            (type, exchange, value) -> getFile2BufferedConverter().genericFileToInputStream((org.apache.camel.component.file.GenericFile) value));
    }

    private static void addTypeConverter(TypeConverterRegistry registry, Class<?> toType, Class<?> fromType, boolean allowNull, SimpleTypeConverter.ConversionMethod method) { 
        registry.addTypeConverter(toType, fromType, new SimpleTypeConverter(allowNull, method));
    }

    private volatile org.apache.camel.example.springboot.grpc.converter.File2BufferedConverter file2BufferedConverter;
    private org.apache.camel.example.springboot.grpc.converter.File2BufferedConverter getFile2BufferedConverter() {
        if (file2BufferedConverter == null) {
            file2BufferedConverter = new org.apache.camel.example.springboot.grpc.converter.File2BufferedConverter();
            CamelContextAware.trySetCamelContext(file2BufferedConverter, camelContext);
        }
        return file2BufferedConverter;
    }
}
