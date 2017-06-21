package com.work.Two.firstSection.main;

import java.io.IOException;

public interface TokenStream {
	public Token getToken() throws IOException;
	public void consumeToken();
}