package Infrastucture;

public class Complex {
    double real; // реальная часть
    double image; // мнимая часть

    public Complex(double real, double image) {// конструктор с параметрами
        this.real = real;
        this.image = image;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImage() {
        return image;
    }

    public void setImage(double image) {
        this.image = image;
    }

    public Complex add (Complex a) {// Добавить комплексные числа
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = real + real2;
        double newImage = image + image2;
        return new Complex(newReal,newImage);
    }

    public Complex sub (Complex a) {// Вычитаем комплексные числа
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = real - real2;
        double newImage = image - image2;
        return new Complex(newReal,newImage);
    }

    public Complex mul (Complex a) {// умножить комплексные числа
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = real*real2 - image*image2;
        double newImage = image*real2 + real*image2;
        return new Complex(newReal,newImage);
    }

    public Complex div (Complex a) {// Делим комплексные числа
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = (real*real2 + image*image2)/(real2*real2 + image2*image2);
        double newImage = (image*real2 - real*image2)/(real2*real2 + image2*image2);
        return new Complex(newReal,newImage);
    }


    @Override
    public String toString() {
        StringBuilder complex = new StringBuilder();
        if(image > 0){
            complex.append(real).append(" + ").append(image).append("i");
        }else if(image < 0){
            complex.append(real).append(image).append("i");
        }else{
            complex.append(real);
        }

        return complex.toString();
    }
}

