# 🌳 Generador de Árboles AVL en Java

Este proyecto permite al usuario insertar números desde consola para construir un árbol AVL dinámico.  
Después de cada inserción, el programa evalúa si el árbol está balanceado.  
En caso de desbalance, detecta el tipo (LL, RR, LR o RL) y aplica automáticamente la rotación necesaria.

El árbol se muestra en consola de forma visual y jerárquica. El programa termina cuando el usuario escribe `"exit"` o `-1`.

---

## 🎯 Objetivo del programa

- Insertar números desde la consola.
- Visualizar el árbol AVL actualizado después de cada inserción.
- Detectar desbalanceos automáticamente y aplicar la rotación adecuada.
- Mostrar en consola qué tipo de rotación se aplicó (LL, RR, LR o RL).
- Finalizar el programa escribiendo `"exit"` o `-1`.

---

![alt text](image.png)
 En este ejemplo, se genera un desbalance en el nodo 30 y se aplica una rotación simple a la derecha (LL).
![alt text](image-1.png)

### ✔️ Entrada desde consola

```bash
Ingresa un número: 30
Ingresa un número: 20
Ingresa un número: 10
