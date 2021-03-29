/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author Rodrigo
 */
public class ProjetoIa {

    public static int simpleWekaTrain(double[] valores) {
        int valorInt = 0;
        try {
            //Reading training arff file

            FileReader trainreader = new FileReader("src/Model/Wine.arff");
            Instances train = new Instances(trainreader);
            train.setClassIndex(0);

            //Instance of NN
            FileInputStream fI = new FileInputStream("src/Model/MultilayerPerceptonFinal.model");

            MultilayerPerceptron mlp = (MultilayerPerceptron) (new ObjectInputStream(fI)).readObject();
            mlp.buildClassifier(train);

            FileReader testreader = new FileReader("src/Model/teste.arff");
            Instances test = new Instances(testreader);
            test.setClassIndex(0);

            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(mlp, test);

            DenseInstance Itest = new DenseInstance(14);
            Itest.setDataset(train);
             
            Itest.setValue(1, valores[1]);
            Itest.setValue(2, valores[2]);
            Itest.setValue(3, valores[3]);
            Itest.setValue(4, valores[4]);
            Itest.setValue(5, valores[5]);
            Itest.setValue(6, valores[6]);
            Itest.setValue(7, valores[7]);
            Itest.setValue(8, valores[8]);
            Itest.setValue(9, valores[9]);
            Itest.setValue(10, valores[10]);
            Itest.setValue(11, valores[11]);
            Itest.setValue(12, valores[12]);
            Itest.setValue(13, valores[13]);
             
            double prob[] = mlp.distributionForInstance(Itest);
            double numero = prob[0];
            DecimalFormat formato = new DecimalFormat("#");
            numero = Double.valueOf(formato.format(numero));
            valorInt = (int) numero;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return valorInt;
    }
}
