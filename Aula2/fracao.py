"""Classe que calcula fracao."""


class Fracao:
    """docstring for Fracao."""

    numerador = 0
    denominador = 0

    def set_numerador(self):
        """Setando o numerador."""
        self.numerador = float(input("Digite o numerador: "))

    def set_denominador(self):
        """Setando o denominador."""
        self.denominador = float(input("Digite o denominador: "))

    def fracao(self):
        """Calculando a fração."""
        return self.numerador / self.denominador


f = Fracao()
f.set_numerador()
f.set_denominador()
print("A fração é: {:2f}".format(f.fracao()))
