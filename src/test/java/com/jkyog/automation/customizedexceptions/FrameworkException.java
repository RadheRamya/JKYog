package com.jkyog.automation.customizedexceptions;

public class FrameworkException extends Exception{

    /**
     *
     */
    private static final long serialVersionID = 1L;

    public FrameworkException()
    {
        super();
    }
    public FrameworkException(String exceptionMessage)
    {
        super(exceptionMessage);
    }

}
