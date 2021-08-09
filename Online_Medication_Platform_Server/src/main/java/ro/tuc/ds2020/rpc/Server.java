package ro.tuc.ds2020.rpc;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import ro.tuc.ds2020.repositories.IntakeRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Server {

    private IntakeRepository intakeRepository;

    @Bean
    MedicationsInterface medObj(IntakeRepository intakeRepository){
        this.intakeRepository = intakeRepository;
        return new MedicationsClass(intakeRepository);
    }

    @Bean(name = "/qbec")
    HttpInvokerServiceExporter accountService() {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(medObj(intakeRepository));
        exporter.setServiceInterface( MedicationsInterface.class );
        return exporter;
    }
}
