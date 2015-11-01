package com.plagdet.injector;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.plagdet.compressor.Compressor;
import com.plagdet.compressor.CompressorImpl;
import com.plagdet.kolmogorov.KolmogorovCalculator;
import com.plagdet.kolmogorov.KolmogorovCalculatorImpl;
import com.plagdet.tokenizer.Tokenizer;
import com.plagdet.tokenizer.TokenizerImpl;

/**
 * DI configuration
 * 
 * @author Lukasz Antkowiak
 *
 */
public class AppInjector extends AbstractModule {

	@Override
	protected void configure() {
		bind(Tokenizer.class).to(TokenizerImpl.class);
		bind(new TypeLiteral<Compressor<Integer>>() {}).to(new TypeLiteral<CompressorImpl<Integer>>() {});
		bind(KolmogorovCalculator.class).to(KolmogorovCalculatorImpl.class);
	}
}
