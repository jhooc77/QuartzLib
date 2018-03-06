/*
 * Copyright or © or Copr. ZLib contributors (2015 - 2016)
 *
 * This software is governed by the CeCILL-B license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL-B
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-B license and that you accept its terms.
 */

package fr.zcraft.zlib.components.commands2.bb;

import fr.zcraft.zlib.components.commands2.CommandRunnable;
import fr.zcraft.zlib.components.commands2.ParameterTypeConverter;
import fr.zcraft.zlib.components.commands2.exceptions.ParameterTypeConverterException;

import java.util.Arrays;
import java.util.Optional;

public class BBCommand implements CommandRunnable {
    public BBItem item;
    public Optional<Integer> amount;

    static public class BBItem {
        static public final String[] items = {"saw", "stonecutter"};
        public final String itemType;

        public BBItem(String itemType) {
            this.itemType = itemType;
        }
    }

    static public class BBItemParamConverter implements ParameterTypeConverter<BBItem> {
        @Override
        public Class<BBItem> getType() {
            return BBItem.class;
        }

        @Override
        public BBItem fromArgument(String argument) throws ParameterTypeConverterException {
            argument = argument.toLowerCase();
            if(!Arrays.asList(BBItem.items).contains(argument)) throw new ParameterTypeConverterException("Invalid item name");
            return new BBItem(argument);
        }
    }
}