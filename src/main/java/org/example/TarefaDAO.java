package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TarefaDAO {
    private static final String ARQUIVO_TAREFAS = "tarefas.txt";

    public static boolean salvarTarefa(Tarefa tarefa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_TAREFAS, true))) {
            writer.write(tarefa.toString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
