/*
 */
package mhb.projectEuler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
/**
 * This type marks an implementation of a project euler problem. 
 * 
 * If the containing class is given to a test runner, it will run all marked methods and compare the results.
 * 
 * If given to a benchmark runner, all methods will be benchmarked individually.
 * 
 * @author mbauer
 */
public @interface Implementation {
   
}
