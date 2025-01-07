public interface Sortierbar<T> {  // <-- Da wir noch nicht wissen, für welchen Datentyp wir das Interface "Sortierbar" implementieren,
                                  //     kann man an dieser Stelle einen sogenannten "generischen Typ" verwenden. T erhällt hier sozusagen
                                  //     als Wert den Datentyp der das Interface implementierenden Klasse. Diesen können wir dann weiter
                                  //     unten als Typ für den Parameter unserer Methode "vergleichen" benutzen
  
  int vergleichen(T vergleichsElement);  // --> hier wird der Typ T aus dem Klassenkopf wiederverwendet
  // Hinweis: Die Methode wird hier noch nicht konkret implementiert.
  // Bei einer Implementation soll aber folgendes beachtet werden ...
  // Die Methode liefert einen int-Wert zurück. Wenn das aufrufende Element
  // größer ist als das übergebene Vergleichselement, dann soll die Methode
  // die Zahl 1 zurückgeben. Ist das Vergleichselement hingegen größer als
  // das aufrufende Element, dann soll die Methode die Zahl -1 zurückgeben.
  // Sind beide Elemente gleichgroß, dann soll die Zahl 0 zurückgegeben werden.
  
}
