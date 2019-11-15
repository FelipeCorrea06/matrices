package com.matrices.Servicio_Matrices;

import java.awt.print.Printable;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matrices.Servicio_Matrices.service.MatrizService;
import com.matrices.Servicio_Matrices.service.model.MatrizInversa;

@SpringBootApplication
public class ServicioMatricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioMatricesApplication.class, args);
		/*Scanner scan = new Scanner(System.in);
		int a,b;
		System.out.println("Ingrese orden de la matriz");
		a = scan.nextInt();
		
		double[][] i = new double [a][a];
		
		for (int j = 0; j < a; j++) {
			for (int k = 0; k < a; k++) {
				System.out.println("Valor para la posición A["+j+"]["+k+"]:");
				i[j][k] = scan.nextInt();
			}
		}
		MatrizInversa ma = new MatrizInversa();
		
		double [][] fi= ma.inversaMatriz(i);
		System.out.println("Resultado : "+ fi[0][0]);
		
		
		MatrizInversa ma = new MatrizInversa();
		Scanner input = new Scanner(System.in);
        System.out.println("Enter the dimension of square matrix: ");
        int n = input.nextInt();
        double a[][]= new double[n][n];
        System.out.println("Enter the elements of matrix: ");
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                a[i][j] = input.nextDouble();
        double d[][] = ma.invert(a);

        System.out.println("The inverse is: ");

        for (int i=0; i<n; ++i) {
            for (int j=0; j<n; ++j)

            {System.out.print(d[i][j]+"  ");}

            System.out.println();
        }
        input.close();
*/		
	}

}
