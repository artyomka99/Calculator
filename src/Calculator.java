
public class Calculator extends Value {

    private float res;

    public float addition(float num1, float num2) {
        res = num1 + num2;
        return res;
    }
    public float deduction(float num1, float num2) {
        res = num1 - num2;
        return res;
    }
    public float multiplication(float num1, float num2) {
        res = num1 * num2;
        return res;
    }
    public float division(float num1, float num2) {
        if (num2 != 0) {
            System.out.println("You can't divide by zero");;
        }else {
            res = num1 / num2;
        }
        return res;
    }
    public float calculator (float num1, float num2, String action) {
        super.setValues(num1, num2, action);
        switch (action){
            case "+":
                return addition(num1, num2);
            case "-":
                return deduction(num1, num2);
            case "*":
                return multiplication(num1, num2);
            case "/":
                return division(num1, num2);
            default:
                System.out.println("Enter the correct action");
        }
        return 0;
    }
    public String result(){
        return "Result: " + res;
    }
}
