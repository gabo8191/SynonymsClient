package co.edu.uptc.net;

public class Request {

  private String option;
  private String word;
  private String synonym;

  public Request(String option, String word, String synonym) {
    this.option = option;
    this.word = word;
    this.synonym = synonym;
  }

  public String getOption() {
    return option;
  }

  public String getWord() {
    return word;
  }

  public String getSynonym() {
    return synonym;
  }
}
