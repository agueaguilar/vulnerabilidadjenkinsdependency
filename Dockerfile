# Usa una imagen de Java
FROM openjdk:17-jdk-alpine
COPY . /app
WORKDIR /app
RUN ./mvnw clean package
ENTRYPOINT ["java", "-jar", "target/myapp.jar"]

FROM python:3.8-slim

# Copia el archivo de requerimientos
COPY requirements.txt .

# Instala las dependencias de Python
RUN pip3 install -r requirements.txt

# Copia el resto del código
COPY . .

# Comando de ejecución
CMD ["python3", "app.py"]