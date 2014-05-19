package com.entidades;

import java.util.ArrayList;
import java.util.List;

public class CicloEscolar {

  public String string;
  public final List<String> children = new ArrayList<String>();

  public CicloEscolar(String string) {
    this.string = string;
  }

} 