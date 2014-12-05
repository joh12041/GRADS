/**
 * Copyright 2014 CSCI5801 Fall2014 Group1
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.umn.csci5801.model;

import java.lang.Exception;

/**
 * InvalidTermException.java - Class containing exception wrapper
 *
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class InvalidTermException extends Exception{

    /**
     * InvalidTermException() - Method for wrapping an exception in a higher level exception
     *
     * @param message - A variable of type String identifying a message related to an exception
     * @param t - A variable of type Throwable identifying the previous exception
     */
    public InvalidTermException(String message, Throwable t){
        super(message, t);
    }

    /**
     * InvalidTermException() - Method for wrapping an exception in a higher level exception
     *
     * @param t - A variable of type Throwable identifying the previous exception
     */
    public InvalidTermException(Throwable t){
        super(t);
    }

    /**
     * InvalidTermException() - Method for wrapping an exception in a higher level exception
     *
     * @param message - A variable of type String identifying a message related to an exception
     */
    public InvalidTermException(String message){
        super(message);
    }

    /**
     * InvalidTermException() - Method for wrapping an exception in a higher level exception
     */
    public InvalidTermException(){
        super();
    }
}