package br.com.newsletter.oglobo;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(snippets=SnippetType.CAMELCASE,
	monochrome=true, 
	plugin= {"pretty","json:target/cucumber.json"},
	glue= {"br.com.rede.Hooks","br.com.newsletter.oglobo"},
	features="classpath:features",
	tags = "@Test"
	) 
   
public class TestRunner {}
