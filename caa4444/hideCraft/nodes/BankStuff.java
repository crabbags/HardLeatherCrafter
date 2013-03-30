package caa4444.hideCraft.nodes;

import caa4444.hideCraft.misc.Methods;
import caa4444.hideCraft.misc.Variables;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

public class BankStuff extends Node {

    @Override
    public boolean activate() {
        return !Inventory.contains(1743) || Widgets.get(762).validate();
    }

    @Override
    public void execute() {
        if (!Widgets.get(762).validate()) {
            Methods.s("Opening Bank");
            Bank.open();
            Variables.timer.reset();
            while (!Widgets.get(762).validate() && Variables.timer.isRunning()) ;
        } else {
            Methods.s("Banking");
            for (int i = 0; i < 28; i++) {
                if (Inventory.getItemAt(i) != null && Inventory.getItemAt(i).getId() != 1734 &&
                        Bank.deposit(Inventory.getItemAt(i).getId(), Bank.Amount.ALL))
                    Task.sleep(75);
            }
            if (Bank.getItemCount(true, 1743) > 0)
                Bank.withdraw(1743, Bank.Amount.ALL);
            else {
                Methods.stopScript("Out of Leather");
                return;
            }
            Bank.close();
            Variables.timer.reset();
            while (Widgets.get(762).validate() && Variables.timer.isRunning()) ;
        }
    }
}