package com.example.demo.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.reflections.Reflections;

import com.example.demo.command.Command;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CommandService {

    private final PersonService personService;
    private final PetService petService;
    private Map<Long, Command> commands = new HashMap<>();


    private void loadCommands() {
        try {
            Reflections reflections = new Reflections("com.example.demo.command");
            Set<Class<? extends Command>> commandClasses = reflections.getSubTypesOf(Command.class);

            for (Class<? extends Command> clazz : commandClasses) {
                if (!Modifier.isAbstract(clazz.getModifiers())) {
                    try {
                        Command command = clazz.getDeclaredConstructor().newInstance();
                        commands.put(command.getId(), command);
                    } catch (Exception e) {
                        System.err.println("Не удалось создать команду: " + clazz.getSimpleName());
                    }
                }
            }

            if (commands.isEmpty()) {
                System.out.println("Команды не найдены");
            }
        } catch (Exception e) {
            System.err.println("Ошибка при загрузке команд: " + e.getMessage());
        }
    }

    public void startCommandLoop() {
        loadCommands();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            commands.forEach((key, command) ->
                    System.out.println(key + ": " + command.getDescription())
            );
            System.out.println("0: Выход");
            System.out.println("Введите номер команды:");

            try {
                Long commandId = scanner.nextLong();
                scanner.nextLine();

                if (commandId == 0) {
                    System.out.println("До свидания!");
                    System.exit(0);
                }

                Command command = commands.get(commandId);
                if (command != null) {
                    System.out.println("\nВыполняется: " + command.getDescription());
                    command.execute();
                } else {
                    System.out.println("Команда не найдена");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода");
                scanner.nextLine();
            }
        }
    }
}