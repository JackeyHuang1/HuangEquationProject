public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double slope() {
        return roundedToHundredth((y2-y1) / (double) (x2-x1));
    }

    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }

    public String equation() {
        String sign = "+ ";
        int y_values = (y2 - y1);
        int x_values = (x2 - x1);
        if (yIntercept() < 0) {
            sign = "";
        }
        if (x2-x1 < 0){
            y_values *= -1;
            x_values *= -1;
        }

        String equation = "y = ";
        if (yIntercept() == 0) {
            if (slope() == 1) {
                equation += "x";
            } else if (slope() == 0){
                equation += 0;
            } else {
                if (y_values % x_values == 0) {
                    equation += slope() + "x";
                } else {
                    equation += y_values + "/" + x_values + "x";
                }
            }
        } else if (slope() == 0) {
            equation += yIntercept();
        } else if (slope() == 1) {
            equation += "x + " + yIntercept();
        } else if (slope() == -1) {
            equation += "-x + " + yIntercept();
        } else if (y_values % x_values != 0) {
            equation +=  y_values + "/" + x_values + "x "+ sign + yIntercept();
        } else {
        equation += (int) slope() + "x "+ sign + yIntercept();
        }
        return equation;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public String coordinateForX(double x) {
        return "The point on the line is (" + x + ", " + roundedToHundredth(x * slope() + yIntercept()) + ")";
    }

    public String lineInfo() {
        return ("\n -------- Line Info --------\n" +
        "The two points are " + "(" + x1 + ", " + y1 + ") " + "and " + "(" + x2 + ", " + y2 + ") \n" +
        "The equation of this line is: " + equation() +
        "\nThe slope of this line is: " + slope() +
        "\nThe y-intercept of this line is: " + yIntercept() +
        "\nThe distance of this line is: " + distance() + "\n");
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}