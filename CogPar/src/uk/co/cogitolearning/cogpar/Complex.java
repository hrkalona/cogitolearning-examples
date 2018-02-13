/* 
 * Fractal Zoomer, Copyright (C) 2017 hrkalona2
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package uk.co.cogitolearning.cogpar;

public final class Complex {

    private double re;
    private double im;

    public Complex() {

        re = 0;
        im = 0;

    }

    public Complex(double re, double im) {

        this.re = re;
        this.im = im;

    }

    public Complex(Complex z) {

        re = z.re;
        im = z.im;

    }

    public final double getRe() {

        return re;

    }

    public final double getIm() {

        return im;

    }

    public final void setRe(double re) {

        this.re = re;

    }

    public final void setIm(double im) {

        this.im = im;

    }

    public final void assign(Complex z) {

        re = z.re;
        im = z.im;

    }

    /*
     * z1 + z2
     */
    public final Complex plus(Complex z) {

        return new Complex(re + z.re, im + z.im);

    }

    /*
     * z1 = z1 + z2
     */
    public final Complex plus_mutable(Complex z) {

        re = re + z.re;
        im = im + z.im;

        return this;

    }

    /*
     *  z + Real
     */
    public final Complex plus(double number) {

        return new Complex(re + number, im);

    }

    /*
     *  z = z + Real
     */
    public final Complex plus_mutable(double number) {

        re = re + number;

        return this;

    }

    /*
     *  z + Imaginary
     */
    public final Complex plus_i(double number) {

        return new Complex(re, im + number);

    }

    /*
     *  z = z + Imaginary
     */
    public final Complex plus_i_mutable(double number) {

        im = im + number;

        return this;

    }

    /*
     *  z1 - z2
     */
    public final Complex sub(Complex z) {

        return new Complex(re - z.re, im - z.im);

    }

    /*
     *  z1 = z1 - z2
     */
    public final Complex sub_mutable(Complex z) {

        re = re - z.re;
        im = im - z.im;

        return this;

    }

    /*
     *  z - Real
     */
    public final Complex sub(double number) {

        return new Complex(re - number, im);

    }

    /*
     *  z = z - Real
     */
    public final Complex sub_mutable(double number) {

        re = re - number;

        return this;

    }

    /*
     *  Real - z1
     */
    public final Complex r_sub(double number) {

        return new Complex(number - re, -im);

    }

    /*
     *  z1 = Real - z1
     */
    public final Complex r_sub_mutable(double number) {

        re = number - re;
        im = -im;

        return this;

    }

    /*
     *  z - Imaginary
     */
    public final Complex sub_i(double number) {

        return new Complex(re, im - number);

    }

    /*
     *  z = z - Imaginary
     */
    public final Complex sub_i_mutable(double number) {

        im = im - number;

        return this;

    }

    /*
     *  Imaginary - z 
     */
    public final Complex i_sub(double number) {

        return new Complex(-re, number - im);

    }

    /*
     *  z = Imaginary - z 
     */
    public final Complex i_sub_mutable(double number) {

        re = -re;
        im = number - im;

        return this;

    }


    /*
     *  z1 * z2
     */
    public final Complex times(Complex z) {

        double temp = z.re;
        double temp2 = z.im;

        return new Complex(re * temp - im * temp2, re * temp2 + im * temp);

        //Gauss
        /*double temp1 = z.re;
         double temp2 = z.im;
        
         double k1 = temp1 * (re + im);
         double k2 = re * (temp2 - temp1);
         double k3 = im * (temp1 + temp2);
        
         return new Complex(k1 - k3, k1 + k2); */
    }

    /*
     *  z1 = z1 * z2
     */
    public final Complex times_mutable(Complex z) {

        double temp = z.re;
        double temp2 = z.im;

        double temp3 = re * temp - im * temp2;
        im = re * temp2 + im * temp;
        re = temp3;

        return this;

    }

    /*
     *  z1 * Real
     */
    public final Complex times(double number) {

        return new Complex(re * number, im * number);

    }

    /*
     *  z1 = z1 * Real
     */
    public final Complex times_mutable(double number) {

        re = re * number;
        im = im * number;

        return this;

    }

    /*
     *  z * Imaginary
     */
    public final Complex times_i(double number) {

        return new Complex(-im * number, re * number);

    }

    /*
     *  z = z * Imaginary
     */
    public final Complex times_i_mutable(double number) {

        double temp = -im * number;
        im = re * number;
        re = temp;

        return this;

    }

    /*
     *  z1 / z2
     */
    public final Complex divide(Complex z) {

        double temp = z.re;
        double temp2 = z.im;
        double temp3 = temp * temp + temp2 * temp2;

        return new Complex((re * temp + im * temp2) / temp3, (im * temp - re * temp2) / temp3);

    }

    /*
     *  z1 = z1 / z2
     */
    public final Complex divide_mutable(Complex z) {

        double temp = z.re;
        double temp2 = z.im;
        double temp3 = temp * temp + temp2 * temp2;

        double temp4 = (re * temp + im * temp2) / temp3;
        im = (im * temp - re * temp2) / temp3;
        re = temp4;

        return this;

    }

    /*
     *  z / Real
     */
    public final Complex divide(double number) {

        return new Complex(re / number, im / number);

    }

    /*
     * z = z / Real
     */
    public final Complex divide_mutable(double number) {

        re = re / number;
        im = im / number;

        return this;

    }

    /*
     *  z1 / Imaginary
     */
    public final Complex divide_i(double number) {

        double temp2 = number;
        double temp3 = temp2 * temp2;

        return new Complex((re + im * temp2) / temp3, (im - re * temp2) / temp3);

    }

    /*
     *  z1 = z1 / Imaginary
     */
    public final Complex divide_i_mutable(double number) {

        double temp2 = number;
        double temp3 = temp2 * temp2;

        double temp4 = (re + im * temp2) / temp3;
        im = (im - re * temp2) / temp3;
        re = temp4;

        return this;

    }

    /*
     *  Real / z
     */
    public final Complex r_divide(double number) {

        double temp = number / (re * re + im * im);

        return new Complex(re * temp, (-im) * temp);

    }

    /*
     *  z = Real / z
     */
    public final Complex r_divide_mutable(double number) {

        double temp = number / (re * re + im * im);

        re = re * temp;
        im = (-im) * temp;

        return this;

    }

    /*
     *  Imaginary / z
     */
    public final Complex i_divide(double number) {

        double temp = number / (re * re + im * im);

        return new Complex(im * temp, re * temp);

    }

    /*
     *  z = Imaginary / z
     */
    public final Complex i_divide_mutable(double number) {

        double temp = number / (re * re + im * im);

        double temp2 = im * temp;
        im = re * temp;
        re = temp2;

        return this;

    }

    /*
     * z = z1 % z2
     */
    public final Complex remainder(Complex z) {

        return this.sub(z.times(this.divide(z).trunc()));

    }

    /*
     * z1 = z1 % z2
     */
    public final Complex remainder_mutable(Complex z) {

        return this.sub_mutable(z.times(this.divide(z).trunc_mutable()));

    }

    /*
     * z = z1 % Real
     */
    public final Complex remainder(double real) {

        return this.sub(this.divide(real).trunc().times(real));

    }

    /*
     * z1 = z1 % Real
     */
    public final Complex remainder_mutable(double real) {

        return this.sub_mutable(this.divide(real).trunc_mutable().times_mutable(real));

    }

    /*
     * z = z1 % Imaginary
     */
    public final Complex remainder_i(double imaginary) {

        return this.sub(this.divide_i(imaginary).trunc().times_i(imaginary));

    }

    /*
     * z1 = z1 % Imaginary
     */
    public final Complex remainder_i_mutable(double imaginary) {

        return this.sub_mutable(this.divide_i(imaginary).trunc_mutable().times_i_mutable(imaginary));

    }

    /*
     * z = Real % z1
     */
    public final Complex r_remainder(double real) {

        return (this.r_divide(real).trunc().times(this)).r_sub(real);

    }

    /*
     * z1 = Real % z1
     */
    public final Complex r_remainder_mutable(double real) {

        Complex a = (this.r_divide(real).trunc().times(this)).r_sub(real);

        re = a.re;
        im = a.im;

        return this;

    }

    /*
     * z = Imaginary % z1
     */
    public final Complex i_remainder(double imaginary) {

        return (this.i_divide(imaginary).trunc().times(this)).i_sub(imaginary);

    }

    /*
     * z1 = Imaginary % z1
     */
    public final Complex i_remainder_mutable(double imaginary) {

        Complex a = (this.i_divide(imaginary).trunc().times(this)).i_sub(imaginary);

        re = a.re;
        im = a.im;

        return this;

    }


    /*
     *  1 / z
     */
    public final Complex reciprocal() {

        double temp = re * re + im * im;

        return new Complex(re / temp, (-im) / temp);

    }

    /*
     *  z = 1 / z
     */
    public final Complex reciprocal_mutable() {

        double temp = re * re + im * im;

        re = re / temp;
        im = (-im) / temp;

        return this;

    }

    /*
     *  z^2
     */
    public final Complex square() {

        double temp = re * im;

        return new Complex((re + im) * (re - im), temp + temp);

    }

    /*
     *  z = z^2
     */
    public final Complex square_mutable() {

        double temp = re * im;

        re = (re + im) * (re - im);
        im = temp + temp;

        return this;

    }

    /*
     *  z^3
     */
    public final Complex cube() {

        double temp = re * re;
        double temp2 = im * im;

        return new Complex(re * (temp - 3 * temp2), im * (3 * temp - temp2));

    }

    /*
     *  z = z^3
     */
    public final Complex cube_mutable() {

        double temp = re * re;
        double temp2 = im * im;

        re = re * (temp - 3 * temp2);
        im = im * (3 * temp - temp2);

        return this;

    }

    /*
     *  z^4
     */
    public final Complex fourth() {

        double temp = re * re;
        double temp2 = im * im;

        return new Complex(temp * (temp - 6 * temp2) + temp2 * temp2, 4 * re * im * (temp - temp2));

    }

    /*
     *  z = z^4
     */
    public final Complex fourth_mutable() {

        double temp = re * re;
        double temp2 = im * im;

        double temp3 = temp * (temp - 6 * temp2) + temp2 * temp2;
        im = 4 * re * im * (temp - temp2);
        re = temp3;

        return this;

    }

    /*
     *  z^5
     */
    public final Complex fifth() {

        double temp = re * re;
        double temp2 = im * im;

        return new Complex(re * (temp * temp + temp2 * (5 * temp2 - 10 * temp)), im * (temp2 * temp2 + temp * (5 * temp - 10 * temp2)));

    }

    /*
     *  z = z^5
     */
    public final Complex fifth_mutable() {

        double temp = re * re;
        double temp2 = im * im;

        re = re * (temp * temp + temp2 * (5 * temp2 - 10 * temp));
        im = im * (temp2 * temp2 + temp * (5 * temp - 10 * temp2));

        return this;

    }

    /*
     *  z^6
     */
    public final Complex sixth() {

        double temp = re * re;
        double temp2 = im * im;
        double temp3 = temp2 * temp2;

        return new Complex(temp * (temp * temp + 15 * temp2 * (temp2 - temp)) - temp3 * temp2, re * im * (temp * (6 * temp - 20 * temp2) + 6 * temp3));

    }

    /*
     *  z = z^6
     */
    public final Complex sixth_mutable() {

        double temp = re * re;
        double temp2 = im * im;
        double temp3 = temp2 * temp2;

        double temp4 = temp * (temp * temp + 15 * temp2 * (temp2 - temp)) - temp3 * temp2;
        im = re * im * (temp * (6 * temp - 20 * temp2) + 6 * temp3);
        re = temp4;

        return this;

    }

    /*
     *  z^7
     */
    public final Complex seventh() {

        double temp = re * re;
        double temp2 = im * im;
        double temp3 = temp2 * temp2;

        return new Complex(re * (temp * temp * temp + temp2 * (temp * (35 * temp2 - 21 * temp) - 7 * temp3)), im * (temp * (temp * (7 * temp - 35 * temp2) + 21 * temp3) - temp3 * temp2));

    }

    /*
     *  z = z^7
     */
    public final Complex seventh_mutable() {

        double temp = re * re;
        double temp2 = im * im;
        double temp3 = temp2 * temp2;

        re = re * (temp * temp * temp + temp2 * (temp * (35 * temp2 - 21 * temp) - 7 * temp3));
        im = im * (temp * (temp * (7 * temp - 35 * temp2) + 21 * temp3) - temp3 * temp2);

        return this;

    }

    /*
     *  z^8
     */
    public final Complex eighth() {

        double temp = re * re;
        double temp2 = im * im;
        double temp3 = temp * temp;
        double temp4 = temp2 * temp2;

        return new Complex(temp * (temp3 * temp + 28 * temp2 * (temp * (2.5 * temp2 - temp) - temp4)) + temp4 * temp4, 8 * re * im * (temp * (7 * temp2 * (temp2 - temp) + temp3) - temp4 * temp2));

    }

    /*
     *  z = z^8
     */
    public final Complex eighth_mutable() {

        double temp = re * re;
        double temp2 = im * im;
        double temp3 = temp * temp;
        double temp4 = temp2 * temp2;

        double temp5 = temp * (temp3 * temp + 28 * temp2 * (temp * (2.5 * temp2 - temp) - temp4)) + temp4 * temp4;
        im = 8 * re * im * (temp * (7 * temp2 * (temp2 - temp) + temp3) - temp4 * temp2);
        re = temp5;

        return this;

    }

    /*
     *  z^9
     */
    public final Complex ninth() {

        double temp = re * re;
        double temp2 = im * im;
        double temp3 = temp * temp;
        double temp4 = temp2 * temp2;

        return new Complex(re * (im * (im * (re * (re * (im * (im * (126 * temp - 84 * temp2)) - 36 * temp3)) + 9 * temp4 * temp2)) + temp3 * temp3), im * (re * (re * (im * (im * (re * (re * (126 * temp2 - 84 * temp)) - 36 * temp4)) + 9 * temp3 * temp)) + temp4 * temp4));

    }

    /*
     *  z = z^9
     */
    public final Complex ninth_mutable() {

        double temp = re * re;
        double temp2 = im * im;
        double temp3 = temp * temp;
        double temp4 = temp2 * temp2;

        double temp5 = re * (im * (im * (re * (re * (im * (im * (126 * temp - 84 * temp2)) - 36 * temp3)) + 9 * temp4 * temp2)) + temp3 * temp3);
        im = im * (re * (re * (im * (im * (re * (re * (126 * temp2 - 84 * temp)) - 36 * temp4)) + 9 * temp3 * temp)) + temp4 * temp4);
        re = temp5;

        return this;

    }

    /*
     *  z^10
     */
    public final Complex tenth() {

        double temp = re * re;
        double temp2 = im * im;
        double temp3 = temp * temp;
        double temp4 = temp2 * temp2;
        double temp5 = temp3 * temp;
        double temp6 = temp4 * temp2;

        return new Complex(temp * (temp5 * temp + temp2 * (temp * (210 * temp2 * (temp - temp2) - 45 * temp3) + 45 * temp6)) - temp6 * temp4, 10 * re * im * (temp * (12 * temp2 * (temp * (2.1 * temp2 - temp) - temp4) + temp5) + temp6 * temp2));

    }

    /*
     *  z = z^10
     */
    public final Complex tenth_mutable() {

        double temp = re * re;
        double temp2 = im * im;
        double temp3 = temp * temp;
        double temp4 = temp2 * temp2;
        double temp5 = temp3 * temp;
        double temp6 = temp4 * temp2;

        double temp7 = temp * (temp5 * temp + temp2 * (temp * (210 * temp2 * (temp - temp2) - 45 * temp3) + 45 * temp6)) - temp6 * temp4;
        im = 10 * re * im * (temp * (12 * temp2 * (temp * (2.1 * temp2 - temp) - temp4) + temp5) + temp6 * temp2);
        re = temp7;

        return this;

    }

    /*
     *  |z|^2
     */
    public final double norm_squared() {

        return re * re + im * im;

    }

    /*
     *  |z|, euclidean norm
     */
    public final double norm() {

        return Math.sqrt(re * re + im * im);

    }

    /*
     * n-norm
     */
    public final Complex nnorm(Complex n) {

        double tempRe = this.getAbsRe();
        double tempIm = this.getAbsIm();

        tempRe = tempRe == 0 ? 1e-14 : tempRe;
        tempIm = tempIm == 0 ? 1e-14 : tempIm;

        Complex a = new Complex(tempRe, 0);
        Complex b = new Complex(tempIm, 0);

        return (a.pow(n).plus(b.pow(n))).pow(n.reciprocal());

    }

    /*
     *  |z1 - z2|^2
     */
    public final double distance_squared(Complex z) {

        double temp_re = re - z.re;
        double temp_im = im - z.im;

        return temp_re * temp_re + temp_im * temp_im;

    }

    /*
     *  <z
     */
    public final double arg() {

        return Math.atan2(im, re);

    }

    /*
     *  |z - Real|^2
     */
    public final double distance_squared(double number) {

        double temp_re = re - number;

        return temp_re * temp_re + im * im;

    }

    /*
     *  |z1 - z2|
     */
    public final double distance(Complex z) {

        double temp_re = re - z.re;
        double temp_im = im - z.im;

        return Math.sqrt(temp_re * temp_re + temp_im * temp_im);

    }

    /*
     *  |z - Real|
     */
    public final double distance(double number) {

        double temp_re = re - number;

        return Math.sqrt(temp_re * temp_re + im * im);

    }

    /*
     *  |Real|
     */
    public final double getAbsRe() {

        return re >= 0 ? re : -re;

    }

    /*
     *  |Imaginary|
     */
    public final double getAbsIm() {

        return im >= 0 ? im : -im;

    }

    /*
     *  abs(z)
     */
    public final Complex abs() {

        return new Complex(re >= 0 ? re : -re, im >= 0 ? im : -im);

    }

    /*
     *  z = abs(z)
     */
    public final Complex abs_mutable() {

        re = re >= 0 ? re : -re;
        im = im >= 0 ? im : -im;

        return this;

    }

    /*
     *  |Re(z)| + Im(z)i
     */
    public final Complex absre() {

        return new Complex(re >= 0 ? re : -re, im);

    }

    /*
     *  z = |Re(z)| + Im(z)i
     */
    public final Complex absre_mutable() {

        re = re >= 0 ? re : -re;

        return this;

    }

    /*
     *  Re(z) + |Im(z)|i
     */
    public final Complex absim() {

        return new Complex(re, im >= 0 ? im : -im);

    }

    /*
     *  z = Re(z) + |Im(z)|i
     */
    public final Complex absim_mutable() {

        im = im >= 0 ? im : -im;

        return this;

    }

    /*
     *  Real -Imaginary i
     */
    public final Complex conjugate() {

        return new Complex(re, -im);

    }

    /*
     *  z = Real -Imaginary i
     */
    public final Complex conjugate_mutable() {

        im = -im;

        return this;

    }

    /*
     *  -z
     */
    public final Complex negative() {

        return new Complex(-re, -im);

    }

    /*
     *  z = -z
     */
    public final Complex negative_mutable() {

        re = -re;
        im = -im;

        return this;

    }

    /*
     *  z^n
     */
    public final Complex pow(double exponent) {

        double temp = Math.pow(re * re + im * im, exponent * 0.5);
        double temp2 = exponent * Math.atan2(im, re);

        return new Complex(temp * Math.cos(temp2), temp * Math.sin(temp2));

    }

    /*
     *  z^n
     */
    public final Complex pow_mutable(double exponent) {

        double temp = Math.pow(re * re + im * im, exponent * 0.5);
        double temp2 = exponent * Math.atan2(im, re);

        re = temp * Math.cos(temp2);
        im = temp * Math.sin(temp2);

        return this;

    }

    /*
     *  z1 ^ z2 = exp(z2 * log(z1))
     */
    public final Complex pow(Complex z) {

        return (z.times(this.log())).exp();

    }

    /*
     *  log(z) = ln|z| + arctan(Im/Re)i
     */
    public final Complex log() {

        return new Complex(Math.log(re * re + im * im) * 0.5, Math.atan2(im, re));

    }

    /*
     *  z = log(z) = ln|z| + arctan(Im/Re)i
     */
    public final Complex log_mutable() {

        double temp = Math.log(re * re + im * im) * 0.5;
        im = Math.atan2(im, re);
        re = temp;

        return this;

    }

    /*
     *  cos(z) = (exp(iz) + exp(-iz)) / 2
     */
    public final Complex cos() {

        double temp = Math.exp(-im);

        double cos_re = Math.cos(re);
        double sin_re = Math.sin(re);

        Complex temp2 = new Complex(temp * cos_re, temp * sin_re);

        double temp3 = Math.exp(im);
        Complex temp4 = new Complex(temp3 * cos_re, temp3 * -sin_re);

        return (temp2.plus(temp4)).times(0.5);

    }

    /*
     *  cosh(z) = (exp(z) + exp(-z)) / 2
     */
    public final Complex cosh() {

        double temp = Math.exp(re);

        double cos_im = Math.cos(im);
        double sin_im = Math.sin(im);

        Complex temp2 = new Complex(temp * cos_im, temp * sin_im);

        double temp3 = Math.exp(-re);
        Complex temp4 = new Complex(temp3 * cos_im, temp3 * -sin_im);

        return (temp2.plus(temp4)).times(0.5);

    }

    /*
     *  acos(z) = pi / 2 + ilog(iz + sqrt(1 - z^2))
     */
    public final Complex acos() {

        return this.asin().r_sub(Math.PI * 0.5);

    }

    /*
     *  acosh(z) = log(z + sqrt(z^2 - 1))
     */
    public final Complex acosh() {

        return this.plus((this.square().sub(1)).sqrt()).log();

    }

    /*
     *  sin(z) = (exp(iz) - exp(-iz)) / 2i
     */
    public final Complex sin() {

        double temp = Math.exp(-im);

        double cos_re = Math.cos(re);
        double sin_re = Math.sin(re);

        Complex temp2 = new Complex(temp * cos_re, temp * sin_re);

        double temp3 = Math.exp(im);
        Complex temp4 = new Complex(temp3 * cos_re, temp3 * -sin_re);

        return (temp2.sub(temp4)).times_i(-0.5);

    }

    /*
     *  sinh(z) = (exp(z) - exp(-z)) / 2
     */
    public final Complex sinh() {

        double temp = Math.exp(re);

        double cos_im = Math.cos(im);
        double sin_im = Math.sin(im);

        Complex temp2 = new Complex(temp * cos_im, temp * sin_im);

        double temp3 = Math.exp(-re);
        Complex temp4 = new Complex(temp3 * cos_im, temp3 * -sin_im);

        return (temp2.sub(temp4)).times(0.5);

    }

    /*
     *  asin(z) =-ilog(iz + sqrt(1 - z^2))
     */
    public final Complex asin() {

        return this.times_i(1).plus((this.square().r_sub(1)).sqrt()).log().times_i(-1);

    }

    /*
     *  asinh(z) = log(z + sqrt(z^2 + 1))
     */
    public final Complex asinh() {

        return this.plus((this.square().plus(1)).sqrt()).log();

    }

    /*
     *  tan(z) = (1 - exp(-2zi)) / i(1 + exp(-2zi))
     */
    public final Complex tan() {

        double temp = Math.exp(2 * im);

        double temp3 = 2 * re;

        double cos_re = Math.cos(temp3);
        double sin_re = Math.sin(temp3);

        Complex temp2 = new Complex(temp * cos_re, temp * -sin_re);

        return (temp2.r_sub(1)).divide((temp2.plus(1)).times_i(1));

    }

    /*
     *  tahn(z) = (1 - exp(-2z)) / (1 + exp(-2z))
     */
    public final Complex tanh() {

        double temp = Math.exp(-2 * re);

        double temp3 = 2 * im;

        double cos_im = Math.cos(temp3);
        double sin_im = Math.sin(temp3);

        Complex temp2 = new Complex(temp * cos_im, temp * -sin_im);

        return (temp2.r_sub(1)).divide(temp2.plus(1));

    }

    /*
     *  atan(z) = (i / 2)log((1 - iz) / (iz + 1))
     */
    public final Complex atan() {

        Complex temp = this.times_i(1);

        return ((temp.r_sub(1)).divide(temp.plus(1))).log().times_i(0.5);

    }

    /*
     *  atanh(z) = (1 / 2)log((z + 1) / (1 - z))
     */
    public final Complex atanh() {

        return ((this.plus(1)).divide(this.r_sub(1))).log().times(0.5);

    }

    /*
     *  cot(z) = i(1 + exp(-2zi)) / (1 - exp(-2zi))
     */
    public final Complex cot() {

        double temp = Math.exp(2 * im);

        double temp3 = 2 * re;

        double cos_re = Math.cos(temp3);
        double sin_re = Math.sin(temp3);

        Complex temp2 = new Complex(temp * cos_re, temp * -sin_re);

        return (temp2.times_i(1).plus_i(1)).divide(temp2.r_sub(1));

    }

    /*
     *  coth(z) =  (1 + exp(-2z)) / (1 - exp(-2z))
     */
    public final Complex coth() {

        double temp = Math.exp(-2 * re);

        double temp3 = 2 * im;

        double cos_im = Math.cos(temp3);
        double sin_im = Math.sin(temp3);

        Complex temp2 = new Complex(temp * cos_im, temp * -sin_im);

        return (temp2.plus(1)).divide(temp2.r_sub(1));

    }

    /*
     *  acot(z) = (i / 2)log((z^2 - iz) / (z^2 + iz))
     */
    public final Complex acot() {

        Complex temp = this.times_i(1);
        Complex temp2 = this.square();

        return ((temp2.sub(temp)).divide(temp2.plus(temp))).log().times_i(0.5);

    }

    /*
     *  acoth(z) = (1 / 2)log((1 + 1/z) / (1 - 1/z))
     */
    public final Complex acoth() {

        Complex temp = this.reciprocal();

        return ((temp.plus(1)).divide(temp.r_sub(1))).log().times(0.5);

    }

    /*
     *  sec(z) = 1 / cos(z)
     */
    public final Complex sec() {

        return this.cos().reciprocal();

    }

    /*
     *  asec(z) = pi / 2 + ilog(sqrt(1 - 1 / z^2) + i / z)
     */
    public final Complex asec() {

        return (((this.square().reciprocal()).r_sub(1).sqrt()).plus(this.i_divide(1))).log().times_i(1).plus(Math.PI * 0.5);

    }

    /*
     *  sech(z) = 1 / cosh(z)
     */
    public final Complex sech() {

        return this.cosh().reciprocal();

    }

    /*
     *  asech(z) = log(sqrt(1 / z^2 - 1) + 1 / z)
     */
    public final Complex asech() {

        return (((this.square().reciprocal()).sub(1).sqrt()).plus(this.reciprocal())).log();

    }

    /*
     *  csc(z) = 1 / sin(z)
     */
    public final Complex csc() {

        return this.sin().reciprocal();

    }

    /*
     *  acsc(z) = -ilog(sqrt(1 - 1 / z^2) + i / z)
     */
    public final Complex acsc() {

        return (((this.square().reciprocal()).r_sub(1).sqrt()).plus(this.i_divide(1))).log().times_i(-1);

    }

    /*
     *  csch(z) = 1 / sinh(z)
     */
    public final Complex csch() {

        return this.sinh().reciprocal();

    }

    /*
     *  acsch(z) = log(sqrt(1 / z^2 + 1) + 1 / z)
     */
    public final Complex acsch() {

        return (((this.square().reciprocal()).plus(1).sqrt()).plus(this.reciprocal())).log();

    }

    /*
     * versine(z) = 1 - cos(z)
     */
    public final Complex vsin() {

        return this.cos().r_sub(1);

    }

    /*
     * arc versine(z) = acos(1 - z)
     */
    public final Complex avsin() {

        return this.r_sub(1).acos();

    }

    /*
     * vercosine(z) = 1 + cos(z)
     */
    public final Complex vcos() {

        return this.cos().plus(1);

    }

    /*
     * arc vercosine(z) = acos(1 + z)
     */
    public final Complex avcos() {

        return this.plus(1).acos();

    }

    /*
     * coversine(z) = 1 - sin(z)
     */
    public final Complex cvsin() {

        return this.sin().r_sub(1);

    }

    /*
     * arc coversine(z) = asin(1 - z)
     */
    public final Complex acvsin() {

        return this.r_sub(1).asin();

    }

    /*
     * covercosine(z) = 1 + sin(z)
     */
    public final Complex cvcos() {

        return this.sin().plus(1);

    }

    /*
     * arc covercosine(z) = asin(1 + z)
     */
    public final Complex acvcos() {

        return this.plus(1).asin();

    }

    /*
     * haversine(z) = versine(z) / 2
     */
    public final Complex hvsin() {

        return this.vsin().times(0.5);

    }

    /*
     * arc haversine(z) = 2 * asin(sqrt(z))
     */
    public final Complex ahvsin() {

        return this.sqrt().asin().times(2);

    }

    /*
     * havercosine(z) = vercosine(z) / 2
     */
    public final Complex hvcos() {

        return this.vcos().times(0.5);

    }

    /*
     * arc havercosine(z) = 2 * acos(sqrt(z))
     */
    public final Complex ahvcos() {

        return this.sqrt().acos().times(2);

    }

    /*
     * hacoversine(z) = coversine(z) / 2
     */
    public final Complex hcvsin() {

        return this.cvsin().times(0.5);

    }

    /*
     * arc hacoversine(z) = asin(1 - 2*z)
     */
    public final Complex ahcvsin() {

        return this.times(2).r_sub(1).asin();

    }

    /*
     * hacovercosine(z) = covercosine(z) / 2
     */
    public final Complex hcvcos() {

        return this.cvcos().times(0.5);

    }

    /*
     * arc hacovercosine(z) = asin(-1 - 2*z)
     */
    public final Complex ahcvcos() {

        return this.times(-2).r_sub(1).asin();

    }

    /*
     * exsecant(z) = sec(z) - 1
     */
    public final Complex exsec() {

        return this.sec().sub(1);

    }

    /*
     * arc exsecant(z) = asec(z + 1)
     */
    public final Complex aexsec() {

        return this.plus(1).asec();

    }

    /*
     * excosecant(z) = csc(z) - 1
     */
    public final Complex excsc() {

        return this.csc().sub(1);

    }

    /*
     * arc excosecant(z) = acsc(z + 1)
     */
    public final Complex aexcsc() {

        return this.plus(1).acsc();

    }


    /*
     *  exp(z) = exp(Re(z)) * (cos(Im(z)) + sin(Im(z))i)
     */
    public final Complex exp() {

        double temp = Math.exp(re);

        return new Complex(temp * Math.cos(im), temp * Math.sin(im));

    }

    /*
     * sqrt(z) = z^0.5
     */
    public final Complex sqrt() {

        double temp = Math.pow(re * re + im * im, 0.25);
        double temp2 = 0.5 * Math.atan2(im, re);

        return new Complex(temp * Math.cos(temp2), temp * Math.sin(temp2));

    }

    /*
     * z = sqrt(z) = z^0.5
     */
    public final Complex sqrt_mutable() {

        double temp = Math.pow(re * re + im * im, 0.25);
        double temp2 = 0.5 * Math.atan2(im, re);

        re = temp * Math.cos(temp2);
        im = temp * Math.sin(temp2);

        return this;

    }

    /*
     *  sin, (sin)'
     */
    public final Complex[] der01_sin() {

        double temp = Math.exp(-im);

        double cos_re = Math.cos(re);
        double sin_re = Math.sin(re);

        Complex temp2 = new Complex(temp * cos_re, temp * sin_re);

        double temp3 = Math.exp(im);
        Complex temp4 = new Complex(temp3 * cos_re, temp3 * -sin_re);

        Complex[] sin_and_der = new Complex[2];

        sin_and_der[0] = (temp2.sub(temp4)).times_i(-0.5);
        sin_and_der[1] = (temp2.plus(temp4)).times(0.5);

        return sin_and_der;

    }

    /*
     *  sin, (sin)', (sin)''
     */
    public final Complex[] der012_sin() {

        double temp = Math.exp(-im);

        double cos_re = Math.cos(re);
        double sin_re = Math.sin(re);

        Complex temp2 = new Complex(temp * cos_re, temp * sin_re);

        double temp3 = Math.exp(im);
        Complex temp4 = new Complex(temp3 * cos_re, temp3 * -sin_re);

        Complex[] sin_and_der = new Complex[3];

        sin_and_der[0] = (temp2.sub(temp4)).times_i(-0.5);
        sin_and_der[1] = (temp2.plus(temp4)).times(0.5);
        sin_and_der[2] = sin_and_der[0].negative();

        return sin_and_der;

    }

    /*
     *  cos, (cos)', (cos)''
     */
    public final Complex[] der01_cos() {

        double temp = Math.exp(-im);

        double cos_re = Math.cos(re);
        double sin_re = Math.sin(re);

        Complex temp2 = new Complex(temp * cos_re, temp * sin_re);

        double temp3 = Math.exp(im);
        Complex temp4 = new Complex(temp3 * cos_re, temp3 * -sin_re);

        Complex[] sin_and_der = new Complex[2];

        sin_and_der[0] = (temp2.plus(temp4)).times(0.5);
        sin_and_der[1] = (temp4.sub(temp2)).times_i(-0.5);

        return sin_and_der;

    }

    /*
     *  cos, (cos)', (cos)''
     */
    public final Complex[] der012_cos() {

        double temp = Math.exp(-im);

        double cos_re = Math.cos(re);
        double sin_re = Math.sin(re);

        Complex temp2 = new Complex(temp * cos_re, temp * sin_re);

        double temp3 = Math.exp(im);
        Complex temp4 = new Complex(temp3 * cos_re, temp3 * -sin_re);

        Complex[] sin_and_der = new Complex[3];

        sin_and_der[0] = (temp2.plus(temp4)).times(0.5);
        sin_and_der[1] = (temp4.sub(temp2)).times_i(-0.5);
        sin_and_der[2] = sin_and_der[0].negative();

        return sin_and_der;

    }

    /*
     *  The closest Gaussian Integer to the Complex number
     */
    public final Complex gaussian_integer() {

        return new Complex((int)(re < 0 ? re - 0.5 : re + 0.5), (int)(im < 0 ? im - 0.5 : im + 0.5));

    }

    /*
     *  z = The closest Gaussian Integer to the Complex number
     */
    public final Complex gaussian_integer_mutable() {

        re = (int)(re < 0 ? re - 0.5 : re + 0.5);
        im = (int)(im < 0 ? im - 0.5 : im + 0.5);

        return this;

    }

    /*
     *  lexicographical comparison between two complex numbers
     * -1 when z1 > z2
     *  1 when z1 < z2
     *  0 when z1 == z2
     */
    public final int compare(Complex z2) {

        if(re > z2.re) {
            return -1;
        }
        else if(re < z2.re) {
            return 1;
        }
        else if(im > z2.im) {
            return -1;
        }
        else if(z2.im > im) {
            return 1;
        }
        else if(re == z2.re && im == z2.im) {
            return 0;
        }

        return 2;
    }

    /*
     * Gamma function with lancos aproximation
     */
    public final Complex gamma_la() {
        double[] p = {0.99999999999980993, 676.5203681218851, -1259.1392167224028,
            771.32342877765313, -176.61502916214059, 12.507343278686905,
            -0.13857109526572012, 9.9843695780195716e-6, 1.5056327351493116e-7};
        int g = 7;
        if(re < 0.5) {
            Complex pi = new Complex(Math.PI, 0);
            return pi.divide((this.times(pi)).sin().times((this.r_sub(1.0)).gamma_la()));
        }

        Complex temp = this.sub(1.0);
        Complex a = new Complex(p[0], 0);
        Complex t = temp.plus(g + 0.5);
        for(int i = 1; i < p.length; i++) {
            a.plus_mutable(new Complex(p[i], 0).divide(temp.plus(i)));
        }

        return new Complex(Math.sqrt(2 * Math.PI), 0).times(t.pow(temp.plus(0.5))).times((t.negative()).exp()).times(a);
    }

    /*
     * Gamma function with stirling aproximation
     */
    public final Complex gamma_st() {

        return (this.r_divide(2 * Math.PI)).sqrt().times((this.divide(Math.E)).pow(this));

    }

    /*
     *  Factorial of z is Gamma(z + 1)
     */
    public final Complex factorial() {

        return (this.plus(1)).gamma_la();

    }

    /*
     * The floor of a complex number
     */
    public final Complex floor() {

        return new Complex(Math.floor(re), Math.floor(im));

    }

    /*
     * z = The floor of a complex number
     */
    public final Complex floor_mutable() {

        re = Math.floor(re);
        im = Math.floor(im);

        return this;

    }

    /*
     * The ceil of a complex number
     */
    public final Complex ceil() {

        return new Complex(Math.ceil(re), Math.ceil(im));

    }

    /*
     * z = The ceil of a complex number
     */
    public final Complex ceil_mutable() {

        re = Math.ceil(re);
        im = Math.ceil(im);

        return this;

    }

    /*
     * The truncate of a complex number
     */
    public final Complex trunc() {

        return new Complex((int)re, (int)im);

    }

    /*
     * z = The truncate of a complex number
     */
    public final Complex trunc_mutable() {

        re = (int)re;
        im = (int)im;

        return this;

    }

    /*
     * The round of a complex number
     */
    public final Complex round() {

        return new Complex(Math.round(re), Math.round(im));

    }

    /*
     * z = The round of a complex number
     */
    public final Complex round_mutable() {

        re = Math.round(re);
        im = Math.round(im);

        return this;

    }

    /*
     * y + xi
     */
    public final Complex flip() {

        return new Complex(im, re);

    }

    /*
     * z = y + xi
     */
    public final Complex flip_mutable() {

        double temp = re;
        re = im;
        im = temp;

        return this;

    }

    public final Complex toBiPolar(Complex a) {

        return this.times(0.5).cot().times(a).times_i(1);

    }

    public final Complex fromBiPolar(Complex a) {

        return this.divide(a.times_i(1)).acot().times(2);

    }

    /* Series approximation of the error function */
    public final Complex erf() {

        Complex sum = new Complex();

        for(int k = 0; k < 50; k++) {
            double temp = 2 * k + 1;
            sum.plus_mutable((this.pow(temp).times(Math.pow(-1, k))).divide(new Complex(k, 0).factorial().times(temp)));
        }

        return sum.times(2.0 / Math.sqrt(Math.PI));

    }

    /* Series approximation of the riemann zeta function */
    public final Complex riemann_zeta() {

        Complex sum = new Complex();

        if(re > 0) {
            Complex temp = this.r_sub(1);
            Complex temp2 = this.negative();
            Complex sum2 = new Complex();

            for(int k = 1; k < 101; k++) {
                sum2.plus_mutable((new Complex(-1, 0).pow(k - 1)).times(new Complex(k, 0).pow(temp2)));
            }

            sum = sum2.divide((new Complex(1, 0).sub(new Complex(2, 0).pow(temp))));
        }
        else {
            Complex temp = this.r_sub(1);

            Complex gamma = temp.gamma_la();

            Complex sum2 = temp.riemann_zeta();

            sum = (new Complex(2, 0).pow(this)).times(new Complex(Math.PI, 0).pow(this.sub(1))).times(gamma).times(this.times(Math.PI * 0.5).sin()).times(sum2);
        }

        return sum;

    }
    
    /*
    * η(z) = (1 - 2^(1-z)) * ζ(z)
    */
    public final Complex dirichlet_eta() {
        
        return  ((new Complex(2, 0).pow(this.r_sub(1))).r_sub(1)).times(this.riemann_zeta());
        
    }

    public final Complex inflection(Complex inf) {

        Complex diff = this.sub(inf);

        return inf.plus(diff.times_mutable(diff));

    }

    public static final String toString2(double real, double imaginary) {
        String temp = "";

        real = real == 0.0 ? 0.0 : real;
        imaginary = imaginary == 0.0 ? 0.0 : imaginary;

        if(imaginary >= 0) {
            temp = real + "+" + imaginary + "i";
        }
        else {
            temp = real + "" + imaginary + "i";
        }

        return temp;
    }

    @Override
    public final String toString() {

        String temp = "";

        if(im > 0) {
            temp = re + "+" + im + "i";
        }
        else if(im == 0) {
            temp = re + "+" + (0.0) + "i";
        }
        else {
            temp = re + "" + im + "i";
        }

        return temp;

    }

    public final Complex fold_out(Complex z2) {

        double norm_sqr = re * re + im * im;

        return norm_sqr > z2.norm_squared() ? this.divide(norm_sqr) : this;

    }

    public final Complex fold_in(Complex z2) {

        double norm_sqr = re * re + im * im;

        return norm_sqr < z2.norm_squared() ? this.divide(norm_sqr) : this;

    }

    public final Complex fold_right(Complex z2) {

        return re < z2.re ? new Complex(re + 2 * (z2.re - re), im) : this;

    }

    public final Complex fold_left(Complex z2) {

        return re > z2.re ? new Complex(re - 2 * (re - z2.re), im) : this;

    }

    public final Complex fold_up(Complex z2) {

        return im < z2.im ? new Complex(re, im + 2 * (z2.im - im)) : this;

    }

    public final Complex fold_down(Complex z2) {

        return im > z2.im ? new Complex(re, im - 2 * (im - z2.im)) : this;

    }

    public final Complex pinch(Complex center, double radius, double amount, double theta) {

        double radius2 = radius * radius;
        double angle = Math.toRadians(theta);
        double dx = re - center.re;
        double dy = im - center.im;
        double distance = dx * dx + dy * dy;

        if(distance > radius2 || distance == 0) {
            return this;
        }
        else {
            double d = Math.sqrt(distance / radius2);
            double t = Math.pow(Math.sin(Math.PI * 0.5 * d), -amount);

            dx *= t;
            dy *= t;

            double e = 1 - d;
            double a = angle * e * e;

            double s = Math.sin(a);
            double c = Math.cos(a);

            return new Complex(center.re + c * dx - s * dy, center.im + s * dx + c * dy);
        }
    }

    public final Complex shear(Complex sh) {

        return new Complex(re + (im * sh.re), im + (re * sh.im));

    }

    public final Complex kaleidoscope(Complex center, double phi, double phi2, double radius, int sides) {

        double angle = Math.toRadians(phi);
        double angle2 = Math.toRadians(phi2);
        double dx = re - center.re;
        double dy = im - center.im;
        double r = Math.sqrt(dx * dx + dy * dy);
        double theta = Math.atan2(dy, dx) - angle - angle2;
        theta = triangle((theta / Math.PI * sides * .5));
        if(radius != 0) {
            double c = Math.cos(theta);
            double radiusc = radius / c;
            r = radiusc * triangle(r / radiusc);
        }
        theta += angle;

        return new Complex(center.re + r * Math.cos(theta), center.im + r * Math.sin(theta));

    }

    public final Complex twirl(Complex center, double theta, double radius) {

        double radius2 = radius * radius;
        double angle = Math.toRadians(theta);

        double dx = re - center.re;
        double dy = im - center.im;
        double distance = dx * dx + dy * dy;
        if(distance > radius2) {
            return this;
        }
        else {
            distance = Math.sqrt(distance);
            double a = Math.atan2(dy, dx) + (angle * (radius - distance)) / radius;
            return new Complex(center.re + distance * Math.cos(a), center.im + distance * Math.sin(a));
        }
    }

    public final Complex circle_inversion(Complex center, double radius) {

        double distance = this.distance_squared(center);
        double radius2 = radius * radius;

        double temp = radius2 / distance;

        return new Complex(center.re + (re - center.re) * temp, center.im + (im - center.im) * temp);

    }

    public final Complex fuzz(Complex distance) {
        double random;

        Complex out = new Complex(re, im);
        //Real modifier
        random = Math.random();
        if(random < 0.5) {
            random = Math.random() * distance.re;
            out.re -= random;
        }
        else {
            random = Math.random() * distance.re;
            out.re += random;
        }

        //Imaginary modifier
        random = Math.random();
        if(random < 0.5) {
            random = Math.random() * distance.im;
            out.im -= random;
        }
        else {
            random = Math.random() * distance.im;
            out.im += random;
        }

        return out;
    }

    public final Complex rotate(Complex degrees) {

        Complex toDeg = degrees.divide(180.0).times(Math.PI);

        return this.times((toDeg.times_i(1)).exp());

    }

    public final Complex rotate_mutable(Complex degrees) {

        Complex toDeg = degrees.divide(180.0).times(Math.PI);

        return this.times_mutable((toDeg.times_i(1)).exp());

    }

    public final Complex fuzz_mutable(Complex distance) {
        double random;
        //Real modifier
        random = Math.random();
        if(random < 0.5) {
            random = Math.random() * distance.re;
            re -= random;
        }
        else {
            random = Math.random() * distance.re;
            re += random;
        }

        //Imaginary modifier
        random = Math.random();
        if(random < 0.5) {
            random = Math.random() * distance.im;
            im -= random;
        }
        else {
            random = Math.random() * distance.im;
            im += random;
        }

        return this;
    }

    public final Complex ripples(Complex wavelength, Complex amplitude, int waveType) {

        double nx = im / wavelength.re;
        double ny = re / wavelength.im;
        double fx, fy;
        switch (waveType) {
            case 0:
            default:
                fx = Math.sin(nx);
                fy = Math.sin(ny);
                break;
            case 1:
                fx = mod(nx, 1);
                fy = mod(ny, 1);
                break;
            case 2:
                fx = triangle(nx);
                fy = triangle(ny);
                break;
        }

        return new Complex(re + amplitude.re * fx, im + amplitude.im * fy);

    }

    private double triangle(double x) {
        double r = mod(x, 1.0f);
        return 2.0f * (r < 0.5 ? r : 1 - r);
    }

    private double mod(double a, double b) {
        int n = (int)(a / b);

        a -= n * b;
        if(a < 0) {
            return a + b;
        }
        return a;
    }
}
