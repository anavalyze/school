[[LK Informatik]]
#12-03-2025

### Normalformen
##### 1. Normalform
- Jedes Attribut hat einen atomaren Wertebereich haben
##### 2. Normalform
- Attribute, welche nicht Teil eines Schlüsselkandidaten sind, sind nicht funktional abhängig von Attributen die Teil eines Schlüsselkandidaten sind 
##### 3. Normalform
- Keine funktionale Abhängigkeit der nicht-Schlüsselkandidaten untereinander
### Atomarer Attributwert
- Attributwert, der nicht weiter in einzelne Attributwerte geteilt werden kann

### Funktional abhängig
- In einer Relation R(A,B) ist das Attribut B von dem Attribut A funktional abhängig, falls zu jedem Wert des Attributs A genau ein Wert des Attributs B gehört.

### Voll funktional abhängig
- In einer Relation R(S1,S2,B) ist das Attribut B von den Schlüsselattributen S1 und S2 voll funktional abhängig, wenn B von den zusammengesetzten Attributen (S1,S2) funktional abhängig ist, nicht aber von einem einzelnen Attribut S1 oder S2.
### Transitiv abhängig
- Wenn A von B (funktional) abhängig ist und B von C, dann ist bei einer transitiven Abhängigkeit auch A von C abhängig
