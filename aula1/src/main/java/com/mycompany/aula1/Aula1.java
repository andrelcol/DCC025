/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.aula1;

import java.util.Scanner;

/**
 *
 * @author ice
 */
public class Aula1 {

    
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double[] coord1;
        coord1 = new double[2];
        double[] coord2;
        coord2 = new double[2];
        double[] coord3;
        coord3 = new double[2];

        coord1[0] = teclado.nextFloat();
        coord1[1] = teclado.nextFloat();
        coord2[0] = teclado.nextFloat();
        coord2[1] = teclado.nextFloat();
        coord3[0] = teclado.nextFloat();
        coord3[1] = teclado.nextFloat();

        double dist12, dist13, dist23;

        dist12 = Math.sqrt(Math.pow((coord2[0] - coord1[0]), 2) + Math.pow(coord2[1] - coord1[1], 2));
        dist13 = Math.sqrt(Math.pow((coord3[0] - coord1[0]), 2) + Math.pow(coord3[1] - coord1[1], 2));
        dist23 = Math.sqrt(Math.pow((coord3[0] - coord2[0]), 2) + Math.pow(coord3[1] - coord2[1], 2));
        /*
        System.out.println("dist12" + dist12);
        System.out.println("dist13" + dist13);
        System.out.println("dist23" + dist23);
         */
        double mat[][];
        mat = new double[3][3];
        mat[0][0] = coord1[0];
        mat[0][1] = coord1[1];
        mat[0][2] = 1;
        mat[1][0] = coord2[0];
        mat[1][1] = coord2[1];
        mat[1][2] = 1;
        mat[2][0] = coord1[0];
        mat[2][1] = coord1[1];
        mat[2][2] = 1;
        
        double det = mat[0][0] * mat[1][1] * mat[2][2] + mat[0][1] * mat[1][2] * mat[2][0] + mat[0][2] * mat[1][0] * mat[2][1];
        det -= mat[0][2] * mat[1][1] * mat[2][0] + mat[0][1] * mat[1][0] * mat[2][2] + mat[0][0] * mat[1][2] * mat[2][1];
        //verifica a condição de tamanho dos lados do triangulo
        if (dist12 > Math.abs(dist13 - dist23)
                && dist13 > Math.abs(dist12 - dist23)
                && dist23 > Math.abs(dist12 - dist13)) {
            //verifica se os pontos não são colineares
            if(det != 0) {
                if (dist12 == dist13 && dist12 == dist23 && dist13 == dist23) {
                    System.out.println("Equilatero");
                }
                if (dist12 == dist13 && dist13 != dist23
                        || dist12 == dist23 && dist13 != dist23
                        || dist13 == dist23 && dist12 != dist23) {
                    System.out.println("Isosceles");
                }
                if (dist12 != dist13 && dist12 != dist23 && dist13 != dist23) {
                    System.out.println("Escaleno");
                }
            }

        }
    }
}
