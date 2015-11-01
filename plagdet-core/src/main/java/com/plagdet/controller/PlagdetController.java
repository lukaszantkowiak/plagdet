package com.plagdet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.plagdet.compressor.Compressor;
import com.plagdet.injector.AppInjector;
import com.plagdet.kolmogorov.KolmogorovCalculationResult;
import com.plagdet.kolmogorov.KolmogorovCalculator;
import com.plagdet.tokenizer.Tokenizer;
import com.plagdet.tokenizer.lexers.LexerType;

public class PlagdetController {

	private Tokenizer tokenizer;

	private Compressor<Integer> compressor;

	private KolmogorovCalculator kolmogorovCalculator;

	public static PlagdetController getInstance() {
		final Injector injector = Guice.createInjector(new AppInjector());

		return injector.getInstance(PlagdetController.class);
	}

	@Inject
	public void setTokenizer(final Tokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	@Inject
	public void setCompressor(final Compressor<Integer> compressor) {
		this.compressor = compressor;
	}

	@Inject
	public void setKolmogorovCalculator(final KolmogorovCalculator kolmogorovCalculator) {
		this.kolmogorovCalculator = kolmogorovCalculator;
	}

	public KolmogorovCalculationResult calculate(final LexerType lexerType, String data1, String data2) {
		final List<Integer> tokenizedData1 = this.tokenizer.tokenize(lexerType, data1);
		final List<Integer> tokenizedData2 = this.tokenizer.tokenize(lexerType, data2);
		final List<Integer> tokenizedData1_2 = new ArrayList<>();
		tokenizedData1_2.addAll(tokenizedData1);
		tokenizedData1_2.addAll(tokenizedData2);

		final int encodedData1Size = this.compressor.encode(tokenizedData1).size();
		final int encodedData2Size = this.compressor.encode(tokenizedData2).size();
		final int encodedData1_2Size = this.compressor.encode(tokenizedData1_2).size();

		return kolmogorovCalculator.calculate(encodedData1Size, encodedData2Size, encodedData1_2Size);
	}
}
