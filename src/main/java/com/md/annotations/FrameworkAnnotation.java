package com.md.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.md.enums.CategoryType;

/**
 * Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and 
 * category details to the extent report.<p>
 * 
 * Runtime retention value indicate that this annotation will be available at run time for reflection operations.
 * 
 * Nov 30, 2023 
 * @author Mahesh Deevi
 * @version 1.0
 * @since 1.0
 * @see com.md.tests
 * @see com.md.enums.CategoryType
 */

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {
	
	/**
	 * Store the authors who created the tests in String[]
	 * Manadatory to enter atleast a value
	 * @author Mahesh Deevi
	 * @return String[]
	 * <p>Nov 30, 2023
	 */
    public String[] author();

    /**
	 * Stores the category in form of Enum Array. Include the possible values in {@link com.md.enums.CategoryType}
	 * @author Mahesh Deevi
	 * @return CategoryType[]
	 * <p>Nov 30, 2023
	 */
    public CategoryType[] category();
}

