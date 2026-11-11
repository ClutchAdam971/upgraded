VERSION REFACTOREE - TP METRIQUES CKJM

Contenu :
- src/ : sources Java refactorisees
- metrics_before_recomputed.txt : mesures CKJM sur le code initial
- metrics_after.txt : mesures CKJM sur le code refactorise

Modifications principales :
1. Book.java : suppression de complexMethodExample(), qui etait un exemple artificiel
   de complexite SonarQube sans rapport avec la responsabilite d'un livre.
2. Library.java : getAvailableItems() filtre maintenant les livres empruntes au lieu
   de retourner tous les elements. La liste interne est initialisee directement et
   les doublons/null sont evites lors de l'ajout.
3. Customer.java : champs rendus final lorsque leur reference ne change pas ;
   verification null lors des operations de pret/retour.
4. DigitalBook.java : fileSizeMB est final.

Compilation :
  javac --release 8 -d bin src/library/app/*.java src/library/model/*.java src/library/service/*.java

Execution :
  java -cp bin library.app.LibraryApp

Recalcul CKJM (depuis le dossier contenant ckjm-1.8.jar) :
  java -cp "ckjm-1.8.jar:bin" gr.spinellis.ckjm.MetricsFilter \
    bin/library/app/LibraryApp.class bin/library/model/Book.class \
    bin/library/model/DigitalBook.class bin/library/model/Lendable.class \
    bin/library/service/Customer.class bin/library/service/Library.class > metrics.txt

Les valeurs des deux fichiers de mesures ont ete calculees avec CKJM 1.8,
avec les classes compilees en bytecode Java 8. Le classpath inclut bin afin que
CKJM puisse resoudre les classes du projet. L'ancien CKJM affiche encore des
avertissements concernant java.lang.Object sous un JDK recent ; les valeurs
produites sont celles effectivement emises par CKJM 1.8.

Ordre des colonnes CKJM : WMC DIT NOC CBO RFC LCOM Ca NPM.
