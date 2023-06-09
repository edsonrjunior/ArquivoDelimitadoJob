package com.springbatch.arquivodelimitado.writer;

import com.springbatch.arquivodelimitado.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoDelimitadoWriterConfig {

    @StepScope
    @Bean
    public FlatFileItemWriter<Cliente> leituraArquivoDelimitadoWriter(
            @Value("#{jobParameters['arquivoClientesSaida']}") Resource arquivoClientesSaida
    ) {

        return new FlatFileItemWriterBuilder<Cliente>()
                .name("leituraArquivoDelimitadoWriter")
                .resource(arquivoClientesSaida)
                .delimited()
                .delimiter(";")
                .names("nome", "sobrenome", "idade", "email")
                .build();
    }

}
