public enum RoundMethod {
    FLOOR {
        double roundFunction(double d){
            return Math.floor(d);
        }
    },
    CEIL {
        double roundFunction(double d){
            return Math.ceil(d);
        }
    },
    ROUND {
        double roundFunction(double d){
            return Math.round(d);
        }
    };

    abstract double roundFunction(double value);

    public int roundValue(double roundedValue, int powValue){
        int tenPow = pow(powValue);
        int result = (int) roundFunction(roundedValue / tenPow) * tenPow;
        return result;
    }
    private static int pow(int powValue){
        int result = 1;
        for (int i = 1; i <= powValue; i++){
            result = result * 10;
        }
        return result;
    }
}