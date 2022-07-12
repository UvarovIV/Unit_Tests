package com.example.reflection;

public class WorkWithReflection {
    private String privateField;
    public String publicField;
    protected String protectedField;

    public WorkWithReflection(String privateField, String publicField, String protectedField) {
        this.privateField = privateField;
        this.publicField = publicField;
        this.protectedField = protectedField;
    }

    public WorkWithReflection() {}

    private WorkWithReflection(String publicField, String protectedField) {
        this.publicField = publicField;
        this.protectedField = protectedField;
    }

    public int doubleRandomNumber() throws Exception {
        return randomNumber() * 2;
    }

    private static int randomNumber() throws Exception {
        return (int) (Math.random() * 100 + 1);
    }
    
}
