package com.example.lambdas;
    
public class LambdaProgram {
    
    public static String execute(CustomFunctionalInterfaceWithoutArguments withoutArgs) {
        return withoutArgs.sayHello();
    }
    
    public static int execute(CustomFunctionalInterfaceWithOneArgument withOneArg) {
        return withOneArg.doubleTheNumber(15);
    }
    
    public static double execute(CustomFunctionalInterfaceWithTwoArguments withTwoArgs) {
        return withTwoArgs.raiseToPower(15, 2);
    }
    
    public static void main(String[] args) {
        System.out.println(execute(() -> {
            String s = "Hello, world";
            return s;
        }));

        System.out.println(execute((fArg) -> {
            int result = fArg * 2;
            return result;
        }));

        System.out.println(execute(
            new CustomFunctionalInterfaceWithTwoArguments() {
                @Override
                public double raiseToPower(int fArg, int sArg) {
                    return Math.pow(fArg, sArg);
        }}));
    }
}