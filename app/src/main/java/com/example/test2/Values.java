package com.example.test2;

public class Values {
    private double largura, altura;
    private String furos, tamanho;
    private double precTIJ, largTij, altTij;
    private double quantitativo,argamassa, orcamentotij, orcamentoarg, orcTotal;

    public Values(double altura, double largura, String furos, String tamanho){
        this.largura = largura;
        this.altura = altura;
        this.furos = furos;
        this.tamanho = tamanho;
    }

    public double setPrecTIJ(){
        if(furos.equals("6 Furos")){
            if(tamanho.equals("Pequeno")){
                return precTIJ = 0.42;
            }else if(tamanho.equals("Médio") || tamanho.equals("Grande")){
                return precTIJ = 0.69;
            }
        }

        if(furos.equals("8 Furos")){
            if(tamanho.equals("Pequeno")){
                return precTIJ = 0.79;
            }else if(tamanho.equals("Médio")){
                return precTIJ = 1.10;
            }else if(tamanho.equals("Grande")){
                return precTIJ = 1.14;
            }
        }
        return precTIJ;
    }

    public double setLargTij() {
        if(furos.equals("6 Furos") || furos.equals("8 Furos")){
            if (tamanho.equals("Pequeno")) {
                return largTij = 0.19;
            } else if (tamanho.equals("Médio")) {
                return largTij = 0.24;
            } else if (tamanho.equals("Grande")) {
                return largTij = 0.29;
            }
        }

        return largTij;
    }

    public double setAltTij(){
        if(furos.equals("6 Furos")){
            if(tamanho.equals("Pequeno") || tamanho.equals("Médio") || tamanho.equals("Grande")){
                return  altTij = 0.14;
            }
        }

        if(furos.equals("8 Furos")){
            if(tamanho.equals("Pequeno") || tamanho.equals("Médio") || tamanho.equals("Grande")){
                return  altTij = 0.19;
            }
        }

        return altTij;
    }

    public double getQuantitativo(){
        return quantitativo;
    }
    public  double setQuantitativo(){

        return quantitativo = largura * altura / ((largTij + 0.015) * (altTij+0.015));
    }


    public  double getArgamassa(){
        return argamassa;
    }
    public  double setArgamassa(){
        return argamassa = ((largura * altura) - quantitativo * (largTij * altTij)) * 0.09;
    }

    public double getOrcamentotij(){
        return  orcamentotij;
    }
    public  double setOrcamentotij(){
        return orcamentotij  =   quantitativo * precTIJ;
    }

    public double getOrcamentoarg(){
        return  orcamentoarg;
    }
    public double setOrcamentoarg(){
        return  orcamentoarg = argamassa * 453.33;
    }

    public  double getOrcTotal(){
        return orcTotal;
    }
    public  double setOrcTotal(){
        return orcTotal = orcamentoarg + orcamentotij;
    }
}