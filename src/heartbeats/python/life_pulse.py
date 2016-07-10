import datetime
import myfunctions

#Powitanie
print("Witaj.\nTo jest program do obliczania ilości uderzeń serca \
od momentu narodzin,\naż do teraz.\n")

#Ustalenie obecnej daty i czasu
now = datetime.datetime.now()

    #Pobranie daty i godziny urodzenia od użytkownika
#pętle zapewniające wprowadzenie poprawnego wyniku
count = 0
while count == 0:
    text = 0
    while text == 0:
        date_entry = input("""Podaj datę i godzinę urodzenia w formacie:
    rok, miesiąc, dzień, godzina, minuta

przykład:
    2000, 1, 31, 6, 30
(przedstawia osobę urodzoną 31 stycznia 2000 roku o godz. 6:30)

Podaj datę i godzinę urodzenia: """)
        try:
            year, month, day, hour, minute = map(int, date_entry.split(", "))
            birth_date = datetime.datetime(year, month, day, hour, minute)
            text = 1
        except ValueError:
            print("*\nNiepoprawny format. Spróbuj jeszcze raz.\n",76*"=")
                
    if birth_date < now:
        count = 1
    else:
        print("*\nNależy podać datę i godzinę, która nastąpiła przed obecną\
 datą i godziną.\n", 76*"*")
    

#Pobranie informacji o płci od użytkownika
text1 = 0
while text1 == 0:
    gender = input("Podaj płeć (kobieta/mężczyzna): ")
    if gender.lower() == "kobieta":
        text1 = 1
    elif gender.lower() == "mężczyzna":
        text1 = 1
    else:
        print("\nNiepoprawny format. Spróbuj jeszcze raz.\n",76*"=")

#Pobranie informacji o kondycji od użytkownika
text2 = 0
while text2 == 0:
    condition = input("Podaj kondycję (wyczynowa/świetna/dobra/ponadprzeciętna/\
przecietna/słaba/zła): ")
    if condition.lower() == "wyczynowa":
        text2 = 1
    elif condition.lower() == "świetna":
        text2 = 1
    elif condition.lower() == "dobra":
        text2 = 1
    elif condition.lower() == "ponadprzeciętna":
        text2 = 1
    elif condition.lower() == "przeciętna":
        text2 = 1
    elif condition.lower() == "słaba":
        text2 = 1
    elif condition.lower() == "zła":
        text2 = 1
    else:
        print("Niepoprawny format. Spróbuj jeszcze raz.\n",76*"=")

    #Inicjalizacja zmiennych związanych z długością życia użytkownika
#długość życia wyrażona typem timedelta
diff = now - birth_date
#długość życia w minutach
lifespan = myfunctions.convert_delta(diff)
#zmienna pomocnicza 
life_left = 0
life_left += lifespan

    #Fazy życia
#inicjalizacja granic faz (typ datetime)
infant_start = datetime.datetime(year, month, day, hour, minute)
child_start = datetime.datetime(year + 1, month, day, hour, minute)
teenager_start = datetime.datetime(year + 10, month, day, hour, minute)
start_18_25 = datetime.datetime(year + 18, month, day, hour, minute)
start_26_35 = datetime.datetime(year + 25, month, day, hour, minute)
start_36_45 = datetime.datetime(year + 35, month, day, hour, minute)
start_46_55 = datetime.datetime(year + 45, month, day, hour, minute)
start_56_65 = datetime.datetime(year + 55, month, day, hour, minute)
start_65_plus = datetime.datetime(year + 65, month, day, hour, minute)

#maksymalna długość trwania faz (w minutach)
max_phase_infant = myfunctions.convert_delta(child_start - infant_start)
max_phase_child = myfunctions.convert_delta(teenager_start - child_start)
max_phase_teenager = myfunctions.convert_delta(start_18_25 - teenager_start)
max_phase_18_25 = myfunctions.convert_delta(start_26_35 - start_18_25)
max_phase_26_35 = myfunctions.convert_delta(start_36_45 - start_26_35)
max_phase_36_45 = myfunctions.convert_delta(start_46_55- start_36_45)
max_phase_46_55 = myfunctions.convert_delta(start_56_65 - start_46_55)
max_phase_56_65 = myfunctions.convert_delta(start_65_plus - start_56_65)

#wiek w momencie zakończenia fazy (w minutach)
age_infant = max_phase_infant
age_child = age_infant + max_phase_child
age_teenager = age_child + max_phase_teenager
age_18_25 = age_teenager + max_phase_18_25
age_26_35 = age_18_25 + max_phase_26_35
age_36_45 = age_26_35 + max_phase_36_45
age_46_55 = age_36_45 + max_phase_46_55
age_56_65 = age_46_55 + max_phase_56_65 

#inicjalizacja faktycznej długości trwania faz życia (w minutach)
phase_infant = 0
phase_child = 0
phase_teenager = 0
phase_18_25 = 0
phase_26_35 = 0
phase_36_45 = 0
phase_46_55 = 0
phase_56_65 = 0
phase_65_plus = 0

#zmienna przechowująca czas trwania wszystkich faz poprzedzjących 
#ostatnią aktualnie obliczaną fazę życia
total = 0

    ##obliczanie długości trwania faz
#jeśli czas trwania życia jest krótszy niż rok
if 0 < lifespan < max_phase_infant:
    #przeprowadzane będą obliczenia jedynie dla fazy niemolęcej
    phase_infant += lifespan
#jeśli czas trwania życia jest dłuższy niż rok lub równy rok
else:
    #do fazy niemowlęcej przypisany zostaje najdłuższy możliwy czas
    phase_infant += max_phase_infant
    total += phase_infant
    
#jeśli czas trwania życia mieści się danym przedziale
if age_infant < lifespan <= age_child:
    #obliczenia będą przeprowadzane jedynie do fazy dziecięcej
    #od czasu trwania życia odejmujemy czas trwania poprzedniej fazy
    life_left -= total
    #pozostały czas życia przypisujemy do aktualnej fazy
    phase_child += life_left
#jeśli czas trwania życia jest większy od danego przedziału
elif lifespan >= age_child:
    #do fazy dziecięcej przypisany zostaje najdłuższy możliwy czas
    phase_child += max_phase_child
    total += phase_child

if age_child < lifespan <= age_teenager:
    life_left -= total
    phase_teenager += life_left
elif lifespan >= age_teenager:
    phase_teenager += max_phase_teenager
    total += phase_teenager

if age_teenager < lifespan <= age_18_25:
    life_left -= total
    phase_18_25 += life_left
elif lifespan >= age_18_25:
    phase_18_25 += max_phase_18_25
    total += phase_18_25

if age_18_25 < lifespan <=age_26_35:
    life_left -= total
    phase_26_35 += life_left
elif lifespan >= age_26_35:
    phase_26_35 += max_phase_26_35
    total += phase_26_35
    
if age_26_35 < lifespan <= age_36_45:
    life_left -= total
    phase_36_45 += life_left
elif lifespan >= age_36_45:
    phase_36_45 += max_phase_36_45
    total += phase_36_45
    
if age_36_45 < lifespan <= age_46_55:
    life_left -= total
    phase_46_55 += life_left
elif lifespan >= age_46_55:
    phase_46_55 += max_phase_46_55
    total += phase_46_55
    
if age_46_55 < lifespan <= age_56_65:
    life_left -= total
    phase_56_65 += life_left
elif lifespan >= age_56_65:
    phase_56_65 += max_phase_56_65
    total += phase_56_65
    
if lifespan > age_56_65:
    life_left -= total
    phase_65_plus += life_left

#Liczba uderzeń serca na minutę dla faz niezależnych od kondycji
heart_infant = 130
heart_child = 100
heart_teenager = 85

#Konwersja wartości kondycji na wartość liczbową (int)
if condition.lower() == "wyczynowa":
    condition = 0
elif condition.lower() == "świetna":
    condition = 1
elif condition.lower() == "dobra":
    condition = 2
elif condition.lower() == "ponadprzeciętna":
    condition = 3
elif condition.lower() == "przeciętna":
    condition = 4
elif condition.lower() == "słaba":
    condition = 5
elif condition.lower() == "zła":
    condition = 6

#lista zawierająca czasy trwania poszczególnych faz
phases = [phase_18_25, phase_26_35, phase_36_45, phase_46_55, phase_56_65, phase_65_plus]

"""Relacja kondycji do wieku oraz ilości uderzeń serca na minutę.
Klucze słowników to wartości kondycji, zaś indeksy wartości odpowiadają indeksom faz do których należą.
np. dla klucza == 0 (oznaczającego kondycję wyczynową), wartość o indeksie 0 wynosi 57,
i odpowiada indeksowi 0 listy phases czyli fazie phase_18_25
Dostęp do wartości słowników:
womanHR[1][0] == 63
womanHR[6][1] == 83
menHR[0][0] == 52"""
womanHR = {0 : [57, 56, 56, 57, 56, 56],\
           1 : [63, 62, 62, 63, 62, 62],\
           2 : [68, 66, 67, 68, 66, 66],\
           3 : [72, 70, 72, 72, 71, 70],\
           4 : [76, 74, 76, 76, 76, 74],\
           5 : [82, 80, 82, 80, 80, 80],\
           6 : [85, 83, 85, 84, 84, 84]}

menHR = {0 : [52, 52, 53, 54, 54, 52],\
         1 : [58, 58, 60, 60, 59, 58],\
         2 : [64, 64, 64, 66, 64, 64],\
         3 : [68, 68, 68, 70, 70, 68],\
         4 : [72, 72, 73, 74, 74, 72],\
         5 : [78, 78, 79, 80, 78, 76],\
         6 : [82, 82, 83, 84, 82, 80]}

#inicjalizacja ilości uderzeń serca w  ciągu życia
heartbeats = 0

#liczba uderzeń serca do 18-tego roku życia
heartbeats +=  (phase_infant * heart_infant) + (phase_child * heart_child) + (phase_teenager * heart_teenager)

    #obliczenia dla liczby uderzeń serca powyżej 18-tego roku życia
#dla każdej fazy powyżej 18 lat
for i in phases:
    if gender.lower() == "kobieta":
        #dla każdej potencjalnej kobiecej kodnycji 
        for key in womanHR:
            #obliczenia dla podanej kondycji
            if key == condition:
                #tyle razy ile jest faz
                for j in range(len(phases)):
                    #dodaj do heartbeats wartość fazy (długość trwania w minutach)
                    #pomnożoną przez odpowiednią wartość tętna wybraną ze słownika
                    heartbeats += i * womanHR[key][phases.index(i)]
    if gender.lower() == "mężczyzna":
        for key in menHR:
            if key == condition:
                for j in range(len(phases)):
                    heartbeats += i * menHR[key][phases.index(i)]

print("\nLiczba uderzeń serca od rozpoczęcia życia do teraz \nwynosi w przybliżeniu %0.2f tys." % (heartbeats / 1000))
