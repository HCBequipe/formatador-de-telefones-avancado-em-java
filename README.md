# Detector e Formatador Avançado de Telefones 📞

Aplicação desenvolvida em **Java 21** para análise, higienização, validação de regras de negócio e formatação de números de telefone e celular, tratando 5 cenários complexos de entrada de dados por meio de **Expressões Regulares (Regex)** e **Manipulação de Strings**.

---

## 📌 Cenários Detectados e Tratados

O sistema analisa a entrada fornecida pelo usuário e categoriza a execução em uma das 5 regras especificadas:

1. **Entrada de Números Puros:** Detecta se a extensão (8, 9, 10 ou 11 dígitos) corresponde a um formato válido e aplica a máscara apropriada.
2. **Quantidade de Dígitos Inválida:** Identifica se a entrada contém uma quantidade de números fora dos padrões aceitos (menor que 8 ou maior que 11 dígitos aproveitáveis) e notifica o usuário.
3. **Número Já Formatado Corretamente:** Mantém a formatação original sem alterações e informa o tipo exato de dispositivo detectado.
4. **Máscara Incorreta:** Identifica pontuações/símbolos colocados em posições erradas, corrige a estrutura e aplica a máscara oficial.
5. **Entrada Mista (Texto + Números):** Higieniza caracteres extras e letras, verifica se restaram dígitos suficientes para compor um número válido, informa o tipo de dispositivo e retorna o valor formatado (ou indica entrada inválida).

---

## 📱 Formatos e Dispositivos Suportados

* **8 dígitos:** Telefone Fixo sem DDD (`XXXX-XXXX`)
* **9 dígitos:** Telefone Celular sem DDD (`XXXXX-XXXX`)
* **10 dígitos:** Telefone Fixo com DDD (`(XX)XXXX-XXXX`)
* **11 dígitos:** Telefone Celular com DDD (`(XX)XXXXX-XXXX`)

---

## 🧠 Conceitos Práticos Aplicados

* **Higienização por Regex (`replaceAll("\\D", "")`):** Remove todos os caracteres não numéricos para isolar os dígitos aproveitáveis.
* **Agrupamento e Substituição (`replaceFirst`):** Utiliza grupos de captura (`$1`, `$2`, `$3`) para aplicar parênteses e traços de forma padronizada.
* **Validação de Estado:** Comparação lógica entre a entrada do usuário e o padrão formatado para identificar se o número já estava mascarado corretamente.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21 (JDK 21)
* **IDE Recomendada:** IntelliJ IDEA
* **Versionamento:** Git & GitHub

---

## 🚀 Como Executar o Projeto

1. **Clone o repositório:**
```bash
git clone https://github.com/SEU-USUARIO/NOME-DO-REPOSITORIO.git

```


2. **Abra o projeto no IntelliJ IDEA**.
3. **Execute o arquivo:**
Navegue até `src/FormatadorTelefoneAvancado.java` e rode o método `main`.
4. **Exemplos de Testes no Console:**
* **Entrada:** `11988884444` $\rightarrow$ *Situação:* Apenas números | *Tipo:* Celular com DDD | *Resultado:* `(11)98888-4444`
* **Entrada:** `(11)3333-4444` $\rightarrow$ *Situação:* Já formatado | *Tipo:* Fixo com DDD | *Resultado:* `(11)3333-4444`
* **Entrada:** `11-988884444` $\rightarrow$ *Situação:* Máscara incorreta | *Tipo:* Celular com DDD | *Resultado Corrigido:* `(11)98888-4444`
* **Entrada:** `Contato Lucas: 11988884444!` $\rightarrow$ *Situação:* Entrada com texto/sujeira | *Tipo:* Celular com DDD | *Resultado:* `(11)98888-4444`
* **Entrada:** `12345` $\rightarrow$ *Situação:* Quantidade inválida | *Mensagem de erro exibida*.



---

## ✒️ Autor

Desenvolvido por **[Vinicius Leandro]** durante os estudos de Java.
