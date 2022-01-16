# `Iuliia`

> Transliterate Cyrillic → Latin in every possible way

Transliteration means representing Cyrillic data (mainly names and geographic locations) with Latin letters. It is used
for international passports, visas, green cards, driving licenses, mail and goods delivery etc.

`Iuliia` makes transliteration as easy as:

```kotlin
import it.orlov.iuliia.Schema.MOSMETRO
import it.orlov.iuliia.translate

fun main() {
    println(MOSMETRO.translate("Юлия"))
}
```

## Why use `Iuliia`

- [20 transliteration schemas](https://github.com/nalgeon/iuliia/blob/master/README.md#supported-schemas) (rule sets),
  including all main international and Russian standards.
- Correctly implements not only the base mapping, but all the special rules for letter combinations and word endings (
  AFAIK, Iuliia is the only library which does so).

For schema details and other information, see [iuliia.ru](https://iuliia.ru/) (in Russian).

[Issues and limitations](https://github.com/nalgeon/iuliia/blob/master/README.md#issues-and-limitations)

## Installation

Gradle

```groovy
dependencies {
    implementation 'it.orlov.iuliia:iuliia:1.0.0'
}
```

Maven

```xml
<dependency>
    <groupId>it.orlov.iuliia</groupId>
    <artifactId>iuliia</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Make sure to add or update tests as appropriate.