[[LK Informatik]]
#27-01-2025

_In der Relation (x, f(x)) hat das x eine spezielle Rolle. Welches Attribut einer Relation in
Datenbanken kommt dem am nächsten?_
-> Schlüssel

_Mit Selektion und Projektion haben Sie bereits zwei Operatoren kennengelernt. Informieren Sie
sich über weitere Mengenoperatoren, deren Definition und Schreibweise! Nutzen Sie (auch) das
Lehrbuch „Datenbanken“, S. 40-47. Fertigen Sie entsprechende Notizen an!_
- Durchschnitt - ∩
- Vereinigung - ∪
- Differenz - \
- Produkt - x
- Join - ⋈

_Erläutern Sie den Unterschied zwischen einem Produkt (auch Kreuzprodukt, cross join) und
einem natürlichen Verbund (natural join) zweier Relationen. Warum muss es für einen Verbund
(mindestens) ein gemeinsames Attribut der beteiligten Relationen geben? Wie viele Elemente
haben Produkt und Verbund zweier Relationen, wenn diese jeweils 2000 und 5000 Elemente
sowie genau ein gemeinsames Attribut haben?_
- Cross-Join: Jeder Attribut-wert aus Tabelle 1 wird mit jedem Attribut-wert aus Tabelle 2 kombiniert
- Natural Join: Jeweils 2 Datensätze werden anhand eines gemeinsamen Attributwerts kombiniert, jeder Datensatz wird einmalig kombiniert 


_Bearbeiten Sie die Aufgaben zu Operatoren (s.64/65) im Lehrbuch „Datenbanken“_

a) 

Serviert x Mag

| Bistro | Getränk | Gast | Getränk |
| ------ | ------- | ---- | ------- |
| Uno    | Wasser  | Hans | Wasser  |
| Uno    | Wasser  | Ede  | Wasser  |
| Uno    | Wasser  | Ede  | Kaffee  |
| Uno    | Wasser  | Karl | Kaffee  |
| Uno    | Kaffee  | Hans | Wasser  |
| Uno    | Kaffee  | Ede  | Wasser  |
| Uno    | Kaffee  | Ede  | Kaffee  |
| Uno    | Kaffee  | Karl | Kaffee  |
| Dos    | Kaffee  | Hans | Wasser  |
| Dos    | Kaffe   | Ede  | Wasser  |
| Dos    | Kaffee  | Ede  | Kaffee  |
| Dos    | Kaffe   | Karl | Kaffee  |

Serviert ⋈ Mag


| Bistro | Getränk | Gast | Getränk |
| ------ | ------- | ---- | ------- |
| Uno    | Wasser  | Hans | Wasser  |
| Uno    | Wasser  | Ede  | Wasser  |
| Uno    | Kaffee  | Karl | Kaffee  |
| Dos    | Kaffee  | Ede  | Kaffee  |
| Dos    | Kaffe   | Karl | Kaffee  |
