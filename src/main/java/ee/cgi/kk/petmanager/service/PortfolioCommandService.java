package ee.cgi.kk.petmanager.service;

import ee.cgi.kk.petmanager.model.AddTransactionToPortfolioDto;

public interface PortfolioCommandService {

	void addTransactionToPortfolio(AddTransactionToPortfolioDto request);
	void removeTransactionFromPortfolio(String transactionId);
	void createNewPortfolio(String username);
	boolean userHasAportfolio(String username);
}
