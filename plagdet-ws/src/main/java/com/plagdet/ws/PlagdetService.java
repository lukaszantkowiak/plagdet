package com.plagdet.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.plagdet.Plagdet;
import com.plagdet.kolmogorov.KolmogorovCalculationResult;
import com.plagdet.tokenizer.lexers.LexerType;

@Path("/calculate")
public class PlagdetService {
	@GET
	public Response calculate(@QueryParam("lexer") String lexer, @QueryParam("data1") String data1,
			@QueryParam("data2") String data2) {

		final Plagdet plagdet = new Plagdet();

		final LexerType lexerType = LexerType.getByName(lexer);

		final KolmogorovCalculationResult result = plagdet.calculate(lexerType, data1, data2);

		return Response.status(200).entity(result.toString()).build();
	}
}
