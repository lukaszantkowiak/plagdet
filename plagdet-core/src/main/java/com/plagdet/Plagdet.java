package com.plagdet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.plagdet.controller.PlagdetController;
import com.plagdet.kolmogorov.KolmogorovCalculationResult;
import com.plagdet.tokenizer.lexers.LexerType;

public class Plagdet {

	private final PlagdetController controller;

	public Plagdet() {
		controller = PlagdetController.getInstance();
	}

	public KolmogorovCalculationResult calculate(final LexerType lexerType, final String data1, final String data2) {
		return controller.calculate(lexerType, data1, data2);
	}

	public static void main(String[] args) throws IOException {
		String file1 = new String(Files.readAllBytes(Paths
				.get("E:\\Uczelnia\\Inf2st\\Semestr 3\\Praca magisterska\\Kody\\test3\\lista2\\RozkladLiczbyTest2.java")));
		String file2 = new String(Files.readAllBytes(Paths
				.get("E:\\Uczelnia\\Inf2st\\Semestr 3\\Praca magisterska\\Kody\\test3\\lista2\\RozkladLiczbyTest3.java")));
		
		Plagdet plagdet = new Plagdet();

		KolmogorovCalculationResult resu = plagdet.calculate(LexerType.Java8, file1, file2);
		
		System.out.println("r: " + resu);
	}
}
