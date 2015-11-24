package org.wltea.analyzer.lucene;

import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

public class IKAnalyzerSolrFactory extends TokenizerFactory {
	private boolean isMaxWordLength;

	public IKAnalyzerSolrFactory(Map<String, String> args) {
		super(args);
		assureMatchVersion();
		setMaxWordLength(((String) args.get("isMaxWordLength")).toString().equals("true"));
	}

	public boolean isMaxWordLength() {
		return this.isMaxWordLength;
	}

	public void setMaxWordLength(boolean isMaxWordLength) {
		this.isMaxWordLength = isMaxWordLength;
	}

	public Tokenizer create(AttributeFactory factory, Reader input) {
		Tokenizer _IKTokenizer = new IKTokenizer(input, this.isMaxWordLength);
		return _IKTokenizer;
	}
}
