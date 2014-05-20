package com.entidades;

import java.util.ArrayList;
import java.util.List;

public class Grupo {

  public String string;
  public final List<String> children = new ArrayList<String>();

  public Grupo(String string) {
    this.string = string;
  }

} 