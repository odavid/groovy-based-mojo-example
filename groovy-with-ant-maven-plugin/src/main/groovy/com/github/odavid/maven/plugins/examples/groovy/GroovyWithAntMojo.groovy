package com.github.odavid.maven.plugins.examples.groovy

import org.apache.maven.execution.MavenSession
import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.plugin.MojoFailureException
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import org.apache.maven.project.MavenProject

import com.github.odavid.maven.plugins.groovy.GroovyMojoWithAntLogger


/**
 * @author odavid
 */
@Mojo(name="groovy-with-ant", requiresProject=false, threadSafe=true)
class GroovyWithAntMojo extends GroovyMojoWithAntLogger{

	@Parameter(defaultValue = '${project}', readonly = true, required = true)
	private MavenProject project;
	
	@Parameter(defaultValue = '${session}', readonly = true, required = true)
	private MavenSession session;
	
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		log.info "Running Ant Builder"
		ant.echo( message: 'This is a very simple groovy plugin that executes ant' )
	}
}
