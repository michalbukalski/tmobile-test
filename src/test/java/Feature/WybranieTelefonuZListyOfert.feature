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
    And Z gornej belki wybierz 'Urządzenia'
    When Kliknij 'Bez abonamentu' z kolumny 'Smartwatche i opaski'
    Then Lista produktów 'Bez abonamentu' jest widoczna

  Scenario: Wybór pierwszego produktu
    Given Otwórz odpowiednią przeglądarkę
    And Przejdz na strone 'Tmobile'
    And Z gornej belki wybierz 'Urządzenia'
    And Kliknij 'Bez abonamentu' z kolumny 'Smartwatche i opaski'
    When Kliknij w pierwszy element z listy
    Then Strona produktu jest widoczna

  Scenario: Sprawdzenie czy ceny pozostają bez zmian
    Given Otwórz odpowiednią przeglądarkę
    And Przejdz na strone 'Tmobile'
    And Z gornej belki wybierz 'Urządzenia'
    And Kliknij 'Bez abonamentu' z kolumny 'Smartwatche i opaski'
    And Kliknij w pierwszy element z listy
    And Strona produktu jest widoczna
    When Kwoty Cena na start oraz Rata miesięczna zgadzają się z kwotami w koszyku

  Scenario: Dodanie produktu do koszyka
    Given Otwórz odpowiednią przeglądarkę
    And Przejdz na strone 'Tmobile'
    And Z gornej belki wybierz 'Urządzenia'
    And Kliknij 'Bez abonamentu' z kolumny 'Smartwatche i opaski'
    And Kliknij w pierwszy element z listy
    And Strona produktu jest widoczna
    When Dodaj produkt do koszyka
    Then Strona "Twój koszyk" jest widoczna
    And W prawym górnym rogu widoczna jest ikonka koszyka z liczbą produktów w koszyku