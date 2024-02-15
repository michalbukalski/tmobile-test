Feature: Wybranie telefonu z listy ofert

  Scenario: Otworzenie przeglądarki
    Given Otwórz odpowiednią przeglądarkę
    Then Przeglądarka zostaje otwarta

  Scenario: Przejście na stronę T-Mobile
    Given Otwórz odpowiednią przeglądarkę
    When Przejdz na strone 'Tmobile'
    Then Strona glowna T-Mobile jest widoczna

  Scenario: Wybór sekcji {Urządzenia}"
    Given Otwórz odpowiednią przeglądarkę
    And Przejdz na strone 'Tmobile'
    When Z gornej belki wybierz 'Urządzenia'
    Then Rozwijana lista "Urządzenia" jest widoczna

  Scenario: Wybór kategorii "Bez abonamentu"
    Given Otwórz odpowiednią przeglądarkę
    And Przejdz na strone 'Tmobile'
    And Wybierz sekcję 'Urządzenia'
    When Kliknij "Bez abonamentu" z kolumny 'Smartwatche i oqpaski'
    Then Lista produktów bez abonamentu jest widoczna

  Scenario: Wybór pierwszego produktu
    Given Wybrano kategorię "Bez abonamentu"
    When Kliknij w pierwszy element z listy
    Then Strona produktu jest widoczna

  Scenario: Dodanie produktu do koszyka
    Given Wybrano produkt
    When Dodaj produkt do koszyka
    Then Strona "Twój koszyk" jest widoczna
    And Kwoty "Cena na start" oraz "Rata miesięczna" zgadzają się z kwotami z poprzedniej strony
    And W prawym górnym rogu widoczna jest ikonka koszyka z liczbą produktów w koszyku