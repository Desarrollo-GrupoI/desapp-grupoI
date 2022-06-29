package ar.edu.unq.desapp.grupoi.backenddesappapl.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import javax.persistence.Entity;

@AnalyzeClasses(packages = "ar.edu.unq.desapp.grupoi.backenddesappapl")
public class ArchitectureTest {
	
	@ArchTest
	public static final ArchRule controllerNameRule = classes()
			.that().haveSimpleNameEndingWith("Controller").should().resideInAPackage("..webservice..");
	
	@ArchTest
	public static final ArchRule servicesNameRule = classes()
			.that().haveSimpleNameEndingWith("Service").should().resideInAPackage("..service..");
	
	@ArchTest
	public static final ArchRule repositoriesNameRule = classes()
			.that().haveSimpleNameEndingWith("Repository").should().resideInAPackage("..repositories..");
	
	@ArchTest
	public static final ArchRule controllersCanOnlyBeAccesedByController = classes()
		    .that().resideInAPackage("..webservice..")
		    .should().onlyBeAccessed().byAnyPackage("..webservice..");
	
	@ArchTest
    public static final ArchRule onlyServiceCanAccesAndCallRepository = classes()
            .that().resideInAPackage("..repositories..")
            .should().onlyBeAccessed().byAnyPackage("..service..", "..repositories..");
		
	@ArchTest
	public static final ArchRule servicesCanBeAccesedByControllerOrOtherServices = classes()
		    .that().resideInAPackage("..service..")
		    .should().onlyBeAccessed().byAnyPackage("..webservice..", "..service..", "..security..");
	
	 @ArchTest
	    public static final ArchRule onlyClassesInModelShouldHaveEntityAnnotation = classes()
	            .that().areAnnotatedWith(Entity.class)
	            .should().resideInAPackage("..model..");
	 
	 

}
