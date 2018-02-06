package com.classloader;
/**
 * # Loaded class is always tracker with this (ClassInstance, PackageName,Classloader)
 * 		- ClassInstance : this is .class thing retained.
 * 		- PackageName : Full Qualified name of package.
 * 		- ClassLoader : object of class loader which has loaded the class.
 * # A class can not be again if it is being loaded by same class loader.
 * # Compiler added a new property public static final class that is why you can use MyClass.class property.
 * # Parent of all Class loader is java.lang.ClassLoader. except bootstrap class loader.
 * # Loading class loader is responsibility of it's parent class loader.
 * # if two class loader loads same or different class the defined classed will be treated as different classes.
 * # Sequence of execution of loading class loaders is 
 * 		BootStrapClassLoader  ->   ExtClassLoader (loads classes from java.ext.dirs)
 * 			->  AppClassLoader(This loader application class files) 
 * 
 * @author choprava
 *
 */
public class ClassLoaderConcept {

}
