<!-- Visualizador online: https://stackedit.io/ -->
 ![Logo da UDESC Alto Vale](http://www1.udesc.br/imagens/id_submenu/2019/marca_alto_vale_horizontal_assinatura_rgb_01.jpg)

---

# Classificador de tipo de cultivo de vinho

Atividade desenvolvida para a disciplina de Inteligência Computacional do [Centro de Educação Superior do Alto Vale do Itajaí (CEAVI/UDESC)](https://www.udesc.br/ceavi)

# Sumário
* [Equipe](#equipe)
* [Problema](#problema)
* [Dataset](#dataset)
* [Técnica](#tecnica)
* [Resultados](#resultados)

## [Equipe](#equipe)
 - [**Rodrigo Souza Tassoni**](mailto:tazzsoni@gmail.com) - [TazzSoni](https://github.com/tazzsoni)
 
## [Problema](#problema)

O problema será classificar corretamente o tipo de cultivo de determinado vinho, baseando-se em um conjunto de componentes químicos que compõem este vinho. 

## [Dataset](#dataset)
Este dataset é o resultado de análises quimicas em vinhos fabricados na mesma região da Itália, porém derivados de três tipos distintos de cultivos. A análise determinou a quantidade de 13 substâncias encontradas em cada um dos três tipos de cultivos. 

Como features temos: "Tipo" - número que diz uma classe de vinho específica (essa será a classe alvo);

1.Teor Alcoólico;
2.
3.Ácido málico;
4.Cinzas;
5.Alcalinidade de cinzas;
6.Magnésio;
7.Fenóis totais;
8.Flavonóides;
9.Fenóis não flavonóide;
10.Proantocianidinas;
11.Intensidade da cor;
12.Matiz;
13.OD280 / OD315 de vinhos diluídos;
14.Prolina;

Número de instâncias de cada tipo de cultivo de vinho:

Tipo 1 - 59;
Tipo 2 - 71;
Tipo 3 - 48;

Em inglês o dataset fica com os seguintes nomes de features: 
0.Type;
1.Alcohol;
2.Malic acid;
3.Ash;
4.Alcalinity of ash;
5.Magnesium;
6.Total phenols;
7.Flavanoids;
8.Nonflavanoid phenols;
9.Proanthocyanins;
10.Color intensity;
11.Hue;
12.OD280/OD315 of diluted wines;
13.Proline;
https://www.kaggle.com/brynja/wineuci

## [Técnica](#tecnica)
Para esta técnica como indicado em aula como uma ótmia opção para classificadores, foi utilizado a rede Multilayer Perceptron.

Conforme mostrado em aula, foi utilizado o software [WEKA](https://www.cs.waikato.ac.nz/ml/weka/), que se mostrou uma ferramenta muito útil, tanto para aprendizado, como para propriamente a aplicação a área de inteligência computacional. Com a facilidade do software, se foi testando modelos de aplicação de redes Multilayer Perceptron. Tendo em vista a classe alvo para o nosso classificador, o software permite, após carregar corretamente o dataset, que se selecione vários tipos de técnicas diferentes para execução.

## [Resultados](#resultados)
Inicialmente foi rodado o teste com a rede Multilayer Perceptron, com seus parâmetros em default, usando o dataset inteiro como traing set. Como visto durante execuções, usando o traing set se tem uma taxa de erro mais baixa, e desta forma foi executado uma bateria de testes para encontar a melhor configuração para uma rede Multilayer Perceptron, e após isso será aplicados testes com divisão de conjunto de treio e testes, como também com validação cruzada.

Seguindo foram obtidos os seguintes resultados:

* HiddenLayers 'a' = (attribs + classes) / 2;
* TrainingTime 500;

![image](https://user-images.githubusercontent.com/45270751/112788581-93a82680-9031-11eb-90af-14427c4f8fbc.png)

![image](https://user-images.githubusercontent.com/45270751/112788587-97d44400-9031-11eb-818c-6512aafc6fce.png)


Mesmo sendo os parâmetros default setados no software, a rede Multilayer Perceptron, conforme mostrado em aula, mostrou-se sendo realmente uma ótima escolha para um classificador. Mas seguimos a bateria de testes, afim de mitigar nossa taxa de erros.

Segunda bateria de testes, aumentamos as camadas ocultas para 10 e adicionamos mais 5 camadas de saída.

![image](https://user-images.githubusercontent.com/45270751/112788671-c520f200-9031-11eb-9f4b-807bc2c0aaf7.png)

E obtivemos os seguintes resultados:

![image](https://user-images.githubusercontent.com/45270751/112788684-c9e5a600-9031-11eb-87cb-c7486cf7ebcd.png)

Obteve-se uma leve melhora, porém não muito significativa. Realizando mais algumas rodadas de testes com diferentes construções de camadas ocultas e de saída, a configuração que mostrou um resultado melhor foi:

* HiddenLayers 5,2;

![image](https://user-images.githubusercontent.com/45270751/112788886-411b3a00-9032-11eb-8c1b-3774e29a136f.png)

E obtivemos os seguintes resultados:

![image](https://user-images.githubusercontent.com/45270751/112788770-f4376380-9031-11eb-9246-25548e5ef74f.png)

Um último passo que foi dado, foi aumentando o número de épocas com a finalidade de ver o comportamento da rede:

* HiddenLayers 5,2;
* TrainingTime 1000;
E obtivemos os seguintes resultados:

image![image](https://user-images.githubusercontent.com/45270751/112788997-76278c80-9032-11eb-906e-6910e874a48c.png)

Notou-se uma melhora significativa aumentando o número de épocas, e após mais algumas rodadas de testes, verificou-se que a medida que se aumenta o número de épocas nosso modelo diminui sua taxa de erro, porém em contra partida, aumenta o tempo de processamento. Por exemplo, com 1000 épocas tivemos um tempo de procesamento de 2.6 segundos, enquanto com 3000 épocas o tempo foi 5.17 segundos, ou seja, quase se dobrou o tempo de construção do modelo. Visando uma idéia que este modelo de classificação possa ser aplicado em outras realidades, optei manter ele em 3000 épocas pois sua taxa de erro foi muito abaixo.

Em uma próxima etapa de testes, tendo em vista um modelo quase definido, foi executado testes com validação cruzada (k-fold) e divisão de bloco de treino e teste. Para testes executados com validação cruzada (k-fold) com k=10 obteve-se os seguintes resultados: 

![image](https://user-images.githubusercontent.com/45270751/112789033-85a6d580-9032-11eb-9949-80cfec968089.png)

Abaixo podemos observar com os X's maiores onde houve erro no modelo. 

![image](https://user-images.githubusercontent.com/45270751/112789042-8b042000-9032-11eb-8773-c1f3943ece73.png)

Então foi testado com um pencentual de divisão do dataset de 90% para treino e 10% para teste e os resultados foram os seguintes: 

![image](https://user-images.githubusercontent.com/45270751/112789061-99523c00-9032-11eb-976b-ae5d4cfde520.png)

Devido a diferença significativa nesses ultimo teste, notou-se que com um conjunto de treino maior o modelo se mostrou com uma precisão maior. Com uma ferramenta de uso muito eficiente, o Weka permite que nosso modelo seja salvo e carregado diretamente em uma plaicação java. Para a etapa de testes e finalização da aplicação em java, usando java Swing, foi separado aleatoriamente 10% do dataset para testes reais, e foram obtidos os seguintes resultados:

![image](https://user-images.githubusercontent.com/45270751/112789066-9d7e5980-9032-11eb-9698-5da83f008e74.png)

Estes resultados foram avaliados como satisfatórios para o modelo em si.

Instruções de Uso do Software
Software de uso simples, seguindo no diretório da aplicação, deve-se usar um compilador Java (preferencialmente NetBeans), e importar o projeto. Após, execute o projeto e atribua valores das features e clicando em "Aplicar teste", a aplicação irá classificar seu vinho com qual o tipo de cultivo mais apropriado.

Vídeo
