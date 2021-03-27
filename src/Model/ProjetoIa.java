/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.text.DecimalFormat;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.DenseInstance;
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

            FileReader trainreader = new FileReader("src/projetoia/Wine.arff");
            Instances train = new Instances(trainreader);
            train.setClassIndex(0);

            //Instance of NN
            FileInputStream fI = new FileInputStream("C:\\Users\\Rodrigo\\Documents\\projeto\\Salvos_weka\\multilayer 4-429 80split.model");

            MultilayerPerceptron mlp = (MultilayerPerceptron) (new ObjectInputStream(fI)).readObject();
            mlp.buildClassifier(train);

            //Setting Parameters
            /*mlp.setLearningRate(0.1);
            mlp.setMomentum(0.2);
            mlp.setTrainingTime(5000);
            mlp.setHiddenLayers("5,5,2");
             */
            // mlp.setOptions(Utils.splitOptions("-L 30 -M 0.2 -N 5000 -V 0 -S 0 -E 20 -H \"5,5,2\" -R"));
            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(mlp, train);

            System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
            System.out.println(eval.toSummaryString()); //Summary of Training

            DenseInstance Itest = new DenseInstance(14);
            Itest.setDataset(train);
            /*
            //valor para classe 1
            Itest.setValue(1, 14.23);
            Itest.setValue(2, 1.71);
            Itest.setValue(3, 2.43);
            Itest.setValue(4, 15.6);
            Itest.setValue(5, 127);
            Itest.setValue(6, 2.8);
            Itest.setValue(7, 3.06);
            Itest.setValue(8, 0.28);
            Itest.setValue(9, 2.29);
            Itest.setValue(10,5.64);
            Itest.setValue(11,1.04);
            Itest.setValue(12,3.92);
            Itest.setValue(13,1065);
             */
 /*
            //valor para classe 2
            Itest.setValue(1,13.03 );
            Itest.setValue(2,0.9  );
            Itest.setValue(3,1.71  );
            Itest.setValue(4,16  );
            Itest.setValue(5,86  );
            Itest.setValue(6,1.95 );
            Itest.setValue(7,2.03    );
            Itest.setValue(8,0.24 );
            Itest.setValue(9,1.46   );
            Itest.setValue(10,4.6  );
            Itest.setValue(11,1.19  );
            Itest.setValue(12,2.48 );
            Itest.setValue(13,392  );
            
            //valor para classe 3
            Itest.setValue(1,12.79 );
            Itest.setValue(2,2.67);
            Itest.setValue(3, 2.48 );
            Itest.setValue(4,22 );
            Itest.setValue(5,112 );
            Itest.setValue(6,1.48 );
            Itest.setValue(7, 1.36 );
            Itest.setValue(8,0.24 );
            Itest.setValue(9,1.26 );
            Itest.setValue(10,10.8 );
            Itest.setValue(11,0.48 );
            Itest.setValue(12,1.47 );
            Itest.setValue(13,480);
            
            double prob[] = mlp.distributionForInstance(Itest);
            System.out.println(prob[0]);
             */
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

    /*public static void main(String[] args) throws Exception {
        simpleWekaTrain();

    }
*/
}
